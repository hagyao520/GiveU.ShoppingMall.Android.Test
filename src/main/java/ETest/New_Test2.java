package ETest;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.service.Appium_Service;
import com.dafycredit.giveu.test.util.Config_Util;
import com.dafycredit.giveu.test.util.Constants;

import io.appium.java_client.android.AndroidDriver;

public class New_Test2 {
	
  static public AndroidDriver<WebElement> driver; 
  Appium_Service appiumServer;  

  @BeforeTest
  public void Stup() throws Exception {
	  appiumServer =new Appium_Service();
	  appiumServer.StartAppium();
	  File apk = new File(Config_Util.getProperty("apk.path", Constants.CONFIG_COMMON), "JYQBTest.apk");
	  DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
      capabilities.setCapability("device", "selendroid");
//      capabilities.setCapability("deviceName", "Android Emulator");
      capabilities.setCapability("deviceName", "fc323ca3");
      capabilities.setCapability("udid", "fc323ca3");
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("platformVersion", "5.5.1");  
      capabilities.setCapability("noReset",true); 
      capabilities.setCapability("fullReset",false);
      capabilities.setCapability("sessionOverride",true);  
      capabilities.setCapability("unicodeKeyboard",true);
      capabilities.setCapability("resetKeyboard",true);
      capabilities.setCapability("newCommandTimeout",60000);
      capabilities.setCapability("noSign",true);
      capabilities.setCapability("app", apk.getAbsolutePath()); 
      capabilities.setCapability("autoWebview",true);
      driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);   
  }
  
  @Test
  public void test() throws Exception {
	  
	  System.out.println("Ant Packaged successfully");
  }
  
  @AfterTest
  public void TearDown() throws Exception {
	  driver.quit();
  }
}
