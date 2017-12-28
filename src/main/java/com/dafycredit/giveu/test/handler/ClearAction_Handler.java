package com.dafycredit.giveu.test.handler;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.dafycredit.giveu.test.base.Test_Step;
import com.dafycredit.giveu.test.util.Appium_Util;
import com.dafycredit.giveu.test.util.Selenium_Util;

public class ClearAction_Handler {
	
	/**
	 * <br>Web端清除操作</br>
	 * 
	 * @param step
	 * @throws Exception 
	 */
	public void webClear(Test_Step step) throws Exception {
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement e = Selenium_Util.getElement(step);
		e.clear();	
	}
	
	/**
	 * <br>Android端清除操作</br>
	 * 
	 * @param step
	 * @throws Exception 
	 */
	public void androidClear(Test_Step step) throws Exception {
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement e = Appium_Util.getElement(step);
		e.clear();	
	}
}
