package com.dafycredit.giveu.test.handler;

import java.util.concurrent.TimeUnit;
import com.dafycredit.giveu.test.base.Test_Step;

/**
 * 等待动作处理类
 */
public class WaitAction_Handler {
	
	/**
	 * 强制等待
	 * @param map
	 * @param step
	 */
	public void waitForced(Test_Step step){
		try {
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			String waitTime = step.getValue();
			Thread.sleep(Long.valueOf(waitTime));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Web端隐式等待
	 * @param map
	 * @param step
	 */
	public void webImplicit(Test_Step step){
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		long waitTime = Long.valueOf(step.getValue());
		step.getAndroidDriver().manage().timeouts().implicitlyWait(waitTime, TimeUnit.MILLISECONDS);	
	}

	/**
	 * Android端隐式等待
	 * @param map
	 * @param step
	 */
	public void androidImplicit(Test_Step step){
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		long waitTime = Long.valueOf(step.getValue());
		step.getAndroidDriver().manage().timeouts().implicitlyWait(waitTime, TimeUnit.MILLISECONDS);	
	}
	
}
