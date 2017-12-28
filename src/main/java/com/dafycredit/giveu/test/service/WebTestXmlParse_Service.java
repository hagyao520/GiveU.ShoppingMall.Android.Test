package com.dafycredit.giveu.test.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dafycredit.giveu.test.base.Step_Action;
import com.dafycredit.giveu.test.base.Test_Case;
import com.dafycredit.giveu.test.base.Test_Step;
import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.util.Config_Util;
import com.dafycredit.giveu.test.util.Constants;


/**
 * <br>配置Selenium</br>
 * <br>解析xml到TestUnit</br>
 *
 * @version 1.0
 * @since   1.0
 */
public class WebTestXmlParse_Service {

	private static final Logger LOG = LoggerFactory.getLogger(WebTestXmlParse_Service.class);

	private static WebDriver driver;
	
	/**
	 * <br>Selenium服务配置</br>
	 *
	 * @throws Exception
	 */
	public static void SeleniumFirefoxDriver(){
//		System.setProperty("webdriver.firefox.bin", Config_Util.getProperty("webdriver.firefox.bin", Constants.CONFIG_COMMON));
		File file = new File(Config_Util.getProperty("webdriver.profile", Constants.CONFIG_COMMON));
 	    FirefoxProfile profile = new FirefoxProfile(file);        
 	    driver = new FirefoxDriver(profile);
// 	    driver .manage().window().maximize();//全屏
	}
		
	/**
	 * <br>根据用例的名称，截取图片，进行保存</br>
	 *
	 * @param ScreenshotName
	 */
	public static void screenShot(String ScreenshotName) {

		int t = 1;
		String AppointDir = Config_Util.getProperty("image.dir", Constants.CONFIG_COMMON);
		String picture = AppointDir + ScreenshotName + ".png";

		File file = new File(AppointDir);
		File[] fs = file.listFiles();
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// 指定图片数量，过多删除
		try {
			if (fs.length >= 300) {
				for (File f : fs) {
					if (f.getName().contains("png"))
						f.delete();
				}
			}

			FileUtils.copyFile(screenShot, new File(picture));
			++t;
		} catch (IOException e) {
			System.out.println("截图失败:" + ScreenshotName);
			e.printStackTrace();
		} finally {
			System.out.println("『发现问题』开始执行: " + "<截图操作,保存目录为[" + picture + "]>");
		}
	}

	public static Test_Unit parse(String xmlPath){
		SeleniumFirefoxDriver();
		return parse(new File(xmlPath));
	}
		
	/**
	 * <br>解析xml测试场景配置文件，转换为一个TestUnit实例，也就是一个TestCase的集合</br>
	 *
	 * @param xmlFile
	 * @return
	 */
	public static Test_Unit parse(File xmlFile) {

		Test_Unit test_Unit = null;

		if ( xmlFile == null || !xmlFile.exists()  )
			return test_Unit;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		try {
			builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(xmlFile);
			Element root = doc.getDocumentElement();
			NodeList cases = root.getElementsByTagName("case");
			//存放case的map
			LinkedHashMap<String, Test_Case> caseMap = new LinkedHashMap<String, Test_Case>();
			Element child;
			Test_Case test_Case;
			
			//逐个解析xml中的case元素
			for (int i = 0; i < cases.getLength(); i++) {
				child = (Element) cases.item(i);
				test_Case = parseTestCase(child);
				
				if (test_Case == null)
					continue;
				
				if (caseMap.containsKey(test_Case.getName()))
					throw new RuntimeException("存在多个" + test_Case.getName() + "，请检查name配置");
				else
					caseMap.put(test_Case.getName(), test_Case);
			}
			
			test_Unit = new Test_Unit();
			test_Unit.setCaseMap(caseMap);		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return test_Unit;
	}

	/**
	 * <br>将case元素解析为TestCase实例，也就是一个TestStep的集合</br>
	 *
	 * @param element 一个case元素
	 * @return
	 */
	private static Test_Case parseTestCase(Element element) {
		if (element == null)
			return null;
		
		NamedNodeMap attrs = element.getAttributes();
		//根据case的属性实例化TestCase，并注入相应字段值
		Test_Case test_Case = initByAttributes(attrs, new Test_Case());
		
		NodeList stepNodes = element.getElementsByTagName("step");
		int len = stepNodes.getLength();
		List<Test_Step> stepList = new ArrayList<Test_Step>(len);
		
		Element stepNode;
		//逐个解析case元素的step子元素
		for (int i = 0; i < len; i++) {
			stepNode = (Element) stepNodes.item(i);
			stepList.add(parseTestStep(stepNode));
		}
		test_Case.setSteps(stepList);
		
		return test_Case;
	}

	/**
	 * <br>解析step元素为TestStep实例</br>
	 *
	 * @param element
	 * @return
	 */
	private static Test_Step parseTestStep(Element element) {
		if (element == null)
			return null;
		
		Test_Step test_Step = initByAttributes(element.getAttributes(), new Test_Step());
		test_Step.setWebDriver(driver);
		
		return test_Step;
	}

	/**
	 * <br>根据xml文件中的元素属性为对象的对应字段注入值</br>
	 *
	 * @param attrs
	 * @param t 需要实例化并注入字段值的对象
	 * @return
	 */
	private static <T> T initByAttributes(NamedNodeMap attrs, T t) {
		if (attrs == null || attrs.getLength() == 0)
			return t;
		
		int len = attrs.getLength();
		Node attr;
		String name, value;
		
		//通过反射逐个注入字段值
		for (int i = 0; i < len; i++) {
			attr = attrs.item(i);
			if (attr == null) continue;
			
			name = attr.getNodeName();
			value = attr.getNodeValue();
			//通过反射为对象的对应字段注入值
			initByReflect(name, value, t);
		}
		return t;
	}

	/**
	 * <br>通过反射为对象的对应字段注入值</br>
	 *
	 * @param name
	 * @param value
	 * @param t
	 * @return
	 */
	private static <T> T initByReflect(String name, String value, T t) {
		if (t == null)
			throw new RuntimeException("null object");
		if (name == null || "".equals(name))
			throw new RuntimeException("empty name");
		
		Class<?> clazz = t.getClass();
		Method setter, getter;

		try {
			String methodStr = name.substring(0, 1).toUpperCase() + name.substring(1);
			
			//如果名称是cancel，则调用isCancel()方法，主要是为了语义上的直观
			getter = clazz.getMethod(("cancel".equals(name) ? "is" : "get") + methodStr, new Class<?>[] {});
			setter = clazz.getMethod("set" + methodStr, getter.getReturnType());
			
			if ("action".equals(name))
				//根据StepAction类中的map来获取名称对应的StepAction（枚举）实例
				setter.invoke(t, Step_Action.action(value));
			else if ("cancel".equals(name))
				setter.invoke(t, "true".equals(value) ? true : false);
			else if("details".equals(name))
				setter.invoke(t,parseDetail(value));
			else
				setter.invoke(t, value);
		} catch (Exception e) {
//			System.out.println("对象反射初始化失败");
//			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * <br>解析行为的细节描述为map</br>
	 *
	 * @author    102051
	 * @date      2017年7月28日 上午11:01:14
	 * @param detail
	 * @return
	 */
	public static Map<String,String> parseDetail(String detail){
		HashMap<String,String> map = new HashMap<>();
		String[] strarr = detail.split(";");
		
		for(String str : strarr){
			map.put(str.split(":")[0], str.split(":")[1]);
		}
		return map;
	}
	
	/**
	 * <br>执行完毕,关闭浏览器</br>
	 */
	public static void closeBrowser() {
		try {
			driver.quit();
			System.out.println("『测试结束』开始执行: <结束进程,关闭浏览器>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
