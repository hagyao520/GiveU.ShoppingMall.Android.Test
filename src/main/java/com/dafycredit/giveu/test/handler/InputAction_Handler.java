package com.dafycredit.giveu.test.handler;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.dafycredit.giveu.test.base.Test_Step;
import com.dafycredit.giveu.test.util.Appium_Util;
import com.dafycredit.giveu.test.util.Selenium_Util;

public class InputAction_Handler {
	
	/**
	 * <br>Web端输入操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void webInput(Test_Step step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement e = Selenium_Util.getElement(step);
		e.clear();
		e.sendKeys(Selenium_Util.parseStringHasEls(step.getValue()));	
	}
	
	/**
	 * <br>Android端输入操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void androidInput(Test_Step step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement e = Appium_Util.getElement(step);
		e.clear();
		e.sendKeys(Appium_Util.parseStringHasEls(step.getValue()));	
	}
	
	/**
	 * <br>Android-ADB指令输入操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void adbInput(Test_Step step) throws Exception{ 
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		Appium_Util.getElement(step).click(); 
		Runtime.getRuntime().exec("adb shell input text "+step.getValue());
	}
}
