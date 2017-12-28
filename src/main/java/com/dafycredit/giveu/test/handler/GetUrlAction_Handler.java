package com.dafycredit.giveu.test.handler;

import java.util.concurrent.TimeUnit;

import com.dafycredit.giveu.test.base.Test_Step;

public class GetUrlAction_Handler {
	
	/**
	 * <br>Web端打开网站链接操作</br>
	 * 
	 * @param step
	 * @throws Exception 
	 */
	public void webGeturl(Test_Step step) throws Exception {
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().get(step.getValue());	
		step.getAndroidDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * <br>Android端打开网站链接操作</br>
	 * 
	 * @param step
	 * @throws Exception 
	 */
	public void androidGeturl(Test_Step step) throws Exception {
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().get(step.getValue());	
		step.getAndroidDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
	}
}
