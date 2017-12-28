package com.dafycredit.giveu.test.handler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.dafycredit.giveu.test.base.Test_Step;
import com.dafycredit.giveu.test.service.AndroidTestXmlParse_Service;
import com.dafycredit.giveu.test.util.Appium_Util;
import com.dafycredit.giveu.test.util.Constants;
import com.dafycredit.giveu.test.util.Selenium_Util;

/**
 * <br>检查操作<br/>
 *
 * @author  102051
 * @email   mengxiw@dafycredit.com
 * @date    2017年7月26日 上午10:27:26
 * @version 1.0
 * @since   1.0
 */
public class CheckAction_Handler {
	
	/**
	 * <br>检查界面上的元素是否与预期值相等</br>
	 *
	 * @author    102051
	 * @date      2017年8月2日 下午6:03:33
	 * @param step
	 * @throws Exception 
	 */
	public void webCheck(Test_Step step) throws Exception{
		String Actual = Selenium_Util.getElement(step).getText();
		String Expected = Selenium_Util.parseStringHasEls(step.getValue());
		String FailHint = step.getMessage();
		String FailedScreenshotCaseName = step.getScreenshot();
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		checkEquals(Actual,Expected,FailHint,FailedScreenshotCaseName);
	}
	
	public void androidCheck(Test_Step step) throws Exception{
		String Actual = Appium_Util.getElement(step).getText();
		String Expected = Appium_Util.parseStringHasEls(step.getValue());
		String FailHint = step.getMessage();
		String FailedScreenshotCaseName = step.getScreenshot();
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		step.getAndroidDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		checkEquals(Actual,Expected,FailHint,FailedScreenshotCaseName);
	}
	
	public void webChecklist(Test_Step step) throws NumberFormatException, Exception{
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		String conditon = step.getDetails().get("condition");
		if(Constants.SIZE_NOT_ZERO.equals(conditon))
			weblistSizeNotZero(step);
		else if(Constants.FIELD.equals(conditon)) 
			webfieldEquals(step);
	}
	
	public void androidChecklist(Test_Step step) throws NumberFormatException, Exception{
		System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
		String conditon = step.getDetails().get("condition");
		if(Constants.SIZE_NOT_ZERO.equals(conditon))
			androidlistSizeNotZero(step);
		else if(Constants.FIELD.equals(conditon)) 
			androidfieldEquals(step);
	}
	
	@SuppressWarnings("unchecked")
	public void weblistSizeNotZero(Test_Step step) throws Exception{
		List<Map<String,Object>>  list = (List<Map<String,Object>>)
		Selenium_Util.parseEL(step.getDetails().get("subject"));
		
		if(list.size() == 0)
			throw new Exception(step.getMessage());
	}
	
	@SuppressWarnings("unchecked")
	public void androidlistSizeNotZero(Test_Step step) throws Exception{
		List<Map<String,Object>>  list = (List<Map<String,Object>>)
		Appium_Util.parseEL(step.getDetails().get("subject"));
		
		if(list.size() == 0)
			throw new Exception(step.getMessage());
	}
	/**
	 * <br>检查列表中的字段值</br>
	 * 此时localmap中的值是一个List<Map<>>，所以需要提供检查的索引
	 *
	 * @author    102051
	 * @date      2017年8月3日 上午9:35:19
	 * @param step
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void webfieldEquals(Test_Step step) throws NumberFormatException, Exception{
//		System.out.println("CHECK_FILED---"+step.getDetails().get("subject"));	
		String Actual = (String)Selenium_Util.parseStringHasEls(step.getDetails().get("subject"));
		String Expected = Selenium_Util.parseStringHasEls(step.getValue());
		String FailHint = step.getMessage();
		try {
			Assert.assertEquals(Actual,Expected,FailHint);
			Thread.sleep(500);
        }
 	    catch (Error | InterruptedException e)  {
 	    	Assert.fail(FailHint +"  "+"Actual 【"+ Actual +"】"+"  "+"but found 【"+ Expected +"】");
 	    }
	}	 

	public void androidfieldEquals(Test_Step step) throws NumberFormatException, Exception{
//		System.out.println("CHECK_FILED---"+step.getDetails().get("subject"));	
		String Actual = (String)Appium_Util.parseStringHasEls(step.getDetails().get("subject"));
		String Expected = Appium_Util.parseStringHasEls(step.getValue());
		String FailHint = step.getMessage();
		try {
			Assert.assertEquals(Actual,Expected,FailHint);
			Thread.sleep(500);
        }
 	    catch (Error | InterruptedException e)  {
 	    	Assert.fail(FailHint +"  "+"Actual 【"+ Actual +"】"+"  "+"but found 【"+ Expected +"】");
 	    }
	}
	
	/**
	 * <br>检查预期与实际是否相等，不等则提示错误信息，并截图</br>
	 *
	 * @author    102051
	 * @date      2017年8月2日 下午6:01:04
	 * @param Actual 
	 * @param Expected
	 * @param FailHint
	 * @param FailedScreenshotCaseName
	 */
	public void checkEquals(String Actual,String Expected,String FailHint,String FailedScreenshotCaseName){
		try {
			Assert.assertEquals(Actual,Expected,FailHint);
			Thread.sleep(500);
        }
 	    catch (Error | InterruptedException e)  {
 	    	AndroidTestXmlParse_Service.screenShot(FailedScreenshotCaseName);
 	    	Assert.fail(FailHint +"  "+"Actual 【"+ Actual +"】"+"  "+"but found 【"+ Expected +"】");
 	    }
	}
}
