/*
 * *****************************************************************************
 *  达飞金融，机密
 *  __________________
 * Copyright@2015-2016 DAFY CREDIT ALL Rights Reserved 达飞金融旗下品牌即有分期 版权所有
 * 备案号：粤ICP备17014188号
 *
 * 注意：
 * 	此处包含的所有信息均为深圳前海达飞金融服务有限公司的财产。知识和技术理念包含在内为深圳前
 * 	海达飞金融服务有限公司所有，可能受中国和国际专利，以及商业秘密或版权法保护。严格禁止传播
 * 	此信息或复制此材料，除非事先获得来自深圳前海达飞金融服务有限公司的书面许可。
 */

package com.dafycredit.giveu.test.service;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.Reporter;

import com.dafycredit.giveu.test.base.Step_Action;
import com.dafycredit.giveu.test.base.Test_Case;
import com.dafycredit.giveu.test.base.Test_Step;
import com.dafycredit.giveu.test.base.Test_Unit;

/**
 * <br>TODO(描述该类的作用)</br>
 *
 * @date    2017年7月27日 下午5:50:09
 * @version 1.0
 * @since   1.0
 */
public class RunUnit_Service {

	private Test_Unit testunit;
	
	public RunUnit_Service(Test_Unit testunit){
		this.testunit = testunit;
	}
	
    /**
     * <br>根据索引从TestUnit中获取测试用例</br>
     *
     * @param index
     * @return
     */
    public Test_Case getCase(int index){
        int n = 0;
        if(testunit.getCaseMap() == null)
            return null;
        
        int size = testunit.getCaseMap().size();
        if(index < 0 || (index > 0 && index >= size))
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
        
        //遍历map内部Entry集合
        for(Map.Entry<String,Test_Case> e : testunit.getCaseMap().entrySet()){
            if(n++ == index)
                return e.getValue();
        }
        
        return null;
    }

    /**
     * <br>根据用例名，即case元素中的name元素值，从TestUnit中获取测试用例</br>
     *
     * @param name
     * @return
     */
    public Test_Case getCase(String name){
        return testunit.getCaseMap() == null ? null : testunit.getCaseMap().get(name);
    }
    
    /**
     * <br>执行测试用例</br>
     *
     * @param name
     * @throws Exception
     */
    public void runCase(String name) throws Exception{
    	Test_Case test_Case = getCase(name);
    	List<Test_Step> steps = test_Case.getSteps();
    	
    	for(Test_Step step : steps){
    		if(step.isCancel())
    			continue;
//    		System.out.println("开始执行: "+step.toString());
    		Step_Action action = step.getAction();
    		Class<?> clazz = action.handler();
    		
    		//如果StepAction实例有handler字段，则调用handler中的方法，否则直接调用run方法
    		if(clazz != null){
    			String key = step.getAction().key();
    			Method m = clazz.getDeclaredMethod(getMethodName(key), new Class<?>[]{Test_Step.class});
    			m.invoke(clazz.newInstance(), step);
    		}else{
    			action.run(step);
    		}
    	}
    }
    
    /**
     * <br>根据step元素的值解析出对应的方法名</br>
     * 作用是将"-"后面的第一个字母转为大写，并且去掉“-”
     *
     * @param actionKey
     * @return
     */
    private String getMethodName(String actionKey){
    	if(actionKey == null || "".equals(actionKey))
    		throw new RuntimeException("empty action key");
    	
    	char[] arr = actionKey.toCharArray();
    	char prevChar = '\0';
    	StringBuilder sb = new StringBuilder();
    	char splitChar = '-';
    	
    	for(char c : arr){
    		if(c == splitChar){
    			prevChar = c;
    			continue;
    		}
    		if(prevChar == splitChar) {
				sb.append(Character.toUpperCase(c));
			} else {
    			sb.append(c);
			}
    		prevChar = c;
    	}
    	
    	return sb.toString();
    }
    
    /**
	 * <br>执行完毕,退出App程序</br>
	 */
	public void closeApp() {
		AndroidTestXmlParse_Service.closeApp();
	}
    
	/**
	 * <br>执行完毕,执行完毕,关闭浏览器</br>
	 */
	public void closeBrowser() {
		WebTestXmlParse_Service.closeBrowser();
	}
	
    /**
     * <br>标记备注，一般展示在测试报告中</br>
     *
     * @param RemarksName
     */
    public void TestReportRemarks(String RemarksName){
 	   Reporter.log(RemarksName);
    }
    
    /**
     * <br>标记备注，一般展示在测试报告中</br>
     *
     * @param command
     */
    public void AndroidAdb(String command) throws IOException{
    	Runtime.getRuntime().exec(command);
    }
}    
