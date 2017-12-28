package com.dafycredit.giveu.test.handler;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.dafycredit.giveu.test.base.Test_Step;
import com.dafycredit.giveu.test.util.Appium_Util;
import com.dafycredit.giveu.test.util.DB_Helper;

public class DBAction_Handler {
	
	public void dbInsert(Test_Step step){
		System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
		int n = DB_Helper.insert(step.getValue());
		if(n > 0){	
		}
	}
	
	public void dbInsertm(Test_Step step){
		System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
		int n = DB_Helper.insert1(step.getValue());
		if(n > 0){	
		}
	}
	
	public void dbDelete(Test_Step step){
		System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
		int n = DB_Helper.delete(step.getValue());
		if(n > 0){	
		}
	}
	
	public void dbDeletem(Test_Step step){
		System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
		int n = DB_Helper.delete1(step.getValue());
		if(n > 0){	
		}
	}
	
	public void dbUpdate(Test_Step step) throws Exception{
		System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
		String sql = Appium_Util.parseStringHasEls(step.getValue());
//		System.err.println("Query-update "+sql);
		int n = DB_Helper.update(sql);
		if(n > 0){
//			System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
//			Reporter.log(base.getDesc());
		}	
	}
	
	public void dbUpdatem(Test_Step step) throws Exception{
		System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
		String sql = Appium_Util.parseStringHasEls(step.getValue());
//		System.err.println("Query-update "+sql);
		int n = DB_Helper.update1(sql);
		if(n > 0){
//			System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
//			Reporter.log(base.getDesc());
		}	
	}
	
	public void dbQuery(Test_Step step) throws Exception{
		if(StringUtils.isBlank(step.getDetails().get("key")))
			throw new Exception("数据库查询务必设置保存结果的键值，供后续操作使用，例子为details='key:credit'！");
		String sql = Appium_Util.parseStringHasEls(step.getValue());
//		System.err.println("Query-sql "+sql);
		System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
		List<Map<String, Object>> st = DB_Helper.query(sql);
		Appium_Util.localmap.put(step.getDetails().get("key").toUpperCase(), st);
//		System.out.println("DBAction: "+AppiumUtil.localmap.toString());
	}
	
	public void dbQuerym(Test_Step step) throws Exception{
		if(StringUtils.isBlank(step.getDetails().get("key")))
			throw new Exception("数据库查询务必设置保存结果的键值，供后续操作使用，例子为details='key:credit'！");
		String sql = Appium_Util.parseStringHasEls(step.getValue());
//		System.err.println("Query-sql "+sql);
		System.out.println("『正常测试』开始执行: "+ step.getValue() + " <" +step.getDesc() + ">");
		List<Map<String, Object>> st = DB_Helper.query1(sql);
		Appium_Util.localmap.put(step.getDetails().get("key").toUpperCase(), st);
//		System.out.println("DBAction: "+AppiumUtil.localmap.toString());
	}
	
	public void dbProcedure(Test_Step step) throws Exception{
		String params = Appium_Util.parseStringHasEls(step.getValue());
		System.out.println("『正常测试』开始执行: "+ step.getDetails().get("prc_name") + params + " <" +step.getDesc() + ">");
		int n =DB_Helper.procedure(step.getDetails().get("prc_name"),params,null);
		if(n > 0){	
		}
	}
	
	public void dbProcedurem(Test_Step step) throws Exception{
		String params = Appium_Util.parseStringHasEls(step.getValue());
		System.out.println("『正常测试』开始执行: "+ step.getDetails().get("prc_name") + params + " <" +step.getDesc() + ">");
		int n =DB_Helper.procedure1(step.getDetails().get("prc_name"),params,null);
		if(n > 0){	
		}
	}
}
