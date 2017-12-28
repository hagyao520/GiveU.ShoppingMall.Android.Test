package com.dafycredit.giveu.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class Test_Base {
	
	private String name;

    private String desc;

    private boolean cancel;

    private WebDriver Wdriver;
    
    private AndroidDriver<WebElement> Adriver;

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public WebDriver getWebDriver() {
        return Wdriver;
    }

    public void setWebDriver(WebDriver driver) {
        this.Wdriver = driver;
    }
    
    public AndroidDriver<WebElement> getAndroidDriver() {
        return Adriver;
    }

    public void setAndroidDriver(AndroidDriver<WebElement> driver) {
        this.Adriver = driver;
    }
}
