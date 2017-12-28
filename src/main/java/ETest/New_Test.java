package ETest;

import java.io.File;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.service.Appium_Service;
import com.dafycredit.giveu.test.util.Config_Util;
import com.dafycredit.giveu.test.util.Constants;

import io.appium.java_client.android.AndroidDriver;

public class New_Test {
	
  static public AndroidDriver<WebElement> driver; 
  Appium_Service appiumServer;  

  @BeforeTest
  public void Stup() throws Exception {
	  appiumServer =new Appium_Service();
	  appiumServer.StartAppium();
	  File apk = new File(Config_Util.getProperty("apk.path", Constants.CONFIG_COMMON), "QQTest.apk");
	  DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("device", "selendroid");
      capabilities.setCapability("deviceName", "Android Emulator");
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("platformVersion", "5.5.1");  
      capabilities.setCapability("noReset",true); 
      capabilities.setCapability("fullReset",false);
      capabilities.setCapability("browserName", "Chrome"); 
      capabilities.setCapability("recreateChromeDriverSessions",true);
      
//      capabilities.setCapability("app", apk.getAbsolutePath());
//      capabilities.setCapability("appPackage", "com.tencent.mm");
//      capabilities.setCapability("appActivity", ".ui.LauncherUI");

//      ChromeOptions options = new ChromeOptions();
//      options.setExperimentalOption("androidProcess", "com.tencent.mm:tools");
//      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
      
//      ChromeOptions options = new ChromeOptions();
//      options.setExperimentalOption("androidProcess", "com.tencent.mobileqq:tool");
//      capabilities.setCapability(ChromeOptions.CAPABILITY, options);

      
      driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);   
  }
  
  @Test
  public void test() throws Exception {
	  
//	  //微信
//	  driver.findElementByName("我").click();
//	  driver.findElementByName("收藏").click();
//	  driver.findElementByName("即有商城").click();
//	  Thread.sleep(5000);
//	  System.out.println(driver.getPageSource());
//	  System.out.println(driver.getContextHandles());
//	  Thread.sleep(3000);
//	  driver.context("WEBVIEW_com.tencent.mm:tools");
//	  System.out.println("已经进入WEBVIEW啦");
//	  System.out.println(driver.getPageSource());
	  
	  //QQ
//	  driver.findElementByAccessibilityId("帐户及设置").click();
//	  driver.findElementByName("我的收藏").click();
//	  driver.findElementByName("我的收藏").click();
//	  driver.findElementByName("1").click();
//	  driver.findElementByName("即有商城").click();
//	  Thread.sleep(3000);
//	  System.out.println(driver.getContextHandles());
////	  driver.context("NATIVE_APP");
//	  Thread.sleep(3000);
//	  driver.context("WEBVIEW_com.tencent.mobileqq:tool");
//	  Thread.sleep(1000);
//	  System.out.println("已经进入WEBVIEW啦");
//	  System.out.println(driver.getPageSource());
	  
	  
//	  Set<String> contextNames = driver.getContextHandles();
//	  Thread.sleep(3000);
//	  for (String contextName : contextNames) {
//	  System.out.println(contextName);
//	   if (contextName.contains("WEBVIEW_com.tencent.mobileqq:tool")){
//	     driver.context(contextName);
//	     System.out.println("已经进入WEBVIEW啦");
//		 System.out.println(driver.getPageSource());
//       }
//	  }  	 
//	  driver.findElementById("sub").click();  
//	  
	  Thread.sleep(3000);
	  driver.get("http://wx.dafycredit.cn/dafy-qq-store/#/activation?_wv=3");
//	  driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]")).click();
	  driver.findElementByXPath("//*[@id='app']/div[1]/div[2]").click();
	  Thread.sleep(3000);
  }
  
  @AfterTest
  public void TearDown() throws Exception {
	  driver.quit();
  }
}
