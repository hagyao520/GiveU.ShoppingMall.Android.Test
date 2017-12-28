package JYQBTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.AndroidTestXmlParse_Service;

public class JYQB_Register_Activation {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	private void stup() throws Exception{
		Test_Unit testunit = AndroidTestXmlParse_Service.parse1("src/main/java/JYQBTestCaseXml/JYQB_Register_Activation.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【即有钱包注册激活流程的测试场景点】-----------------------------------");
	}
		
	@Test
	public void Precondition() throws Exception{
		runService.runCase("前置条件");
		runService.TestReportRemarks("验证在数据库中,执行对应SQL语句,可以正常执行成功");
	}

	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("验证在Android系统中,首次安装启动即有宝APP后,引导页显示正常且可以滑动至最后一页");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在引导页最后一页界面,点击立即体验按钮后,可以正常进入首页购物界面");
	}
	
	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("验证在首页购物界面,未登录用户,选择我的模块,点击立即登录选项后,可以正常进入登录界面");
	}

	@Test
	public void case4() throws Exception{
		runService.runCase("case4");
		runService.TestReportRemarks("验证在登录界面,点击快速注册按钮后,可以正常进入注册界面");
	}
	
	@Test
	public void case5() throws Exception{
		runService.runCase("case5");
		runService.TestReportRemarks("验证在注册界面,输入对应手机号和验证码,点击下一步按钮后,可以正常进入设置登录密码界面");
	}
	
	@Test
	public void case6() throws Exception{
		runService.runCase("case6");
		runService.TestReportRemarks("验证在设置登录密码界面,输入对应登录密码,点击完成按钮后,可以正常注册成功,并自动跳转至登录界面");
	}
	
	@Test
	public void case7() throws Exception{
		runService.runCase("case7");
		runService.TestReportRemarks("验证在登录界面,输入对应账号和密码,点击登录按钮后,可以正常进入设置指纹密码界面,并弹出引导录入指纹弹窗");
	}
	
	@Test
	public void case8() throws Exception{
		runService.runCase("case8");
		runService.TestReportRemarks("验证在设置指纹密码弹窗提醒界面,点击去设置按钮后,可以正常进入Android系统设置界面");
	}
	
	@Test
	public void case9() throws Exception{
		runService.runCase("case9");
		runService.TestReportRemarks("验证在设置指纹密码界面,点击取消按钮后,可以正常跳过设置指纹密码,并进入个人中心界面");
	}
	
	@Test
	public void case_10() throws Exception{
		runService.runCase("case_10");
		runService.TestReportRemarks("验证在个人中心界面,点击查看信用钱包额度选项后,可以正常进入激活即有钱包界面");
	}
	
	@Test
	public void case_11() throws Exception{
		runService.runCase("case_11");
		runService.TestReportRemarks("验证在激活即有钱包界面,点击立即激活按钮后,可以正常进入钱包激活界面");
	}
	
	@Test
	public void case_12() throws Exception{
		runService.runCase("case_12");
		runService.TestReportRemarks("验证在钱包激活界面,输入对应姓名和身份证,点击下一步按钮后,可以正常激活成功,并进入激活成功界面");
	}
	
	@Test
	public void case_13() throws Exception{
		runService.runCase("case_13");
		runService.TestReportRemarks("验证在激活成功界面,点击确定按钮后,可以正常返回个人中心界面");
	}
	
//	@Test
//	public void case_14() throws Exception{
//		runService.runCase("case_14");
//		runService.TestReportRemarks("验证在激活成功界面,点击设置交易密码按钮后,可以正常进入设置交易密码界面");
//	}
//
//	@Test
//	public void case_15() throws Exception{
//		runService.runCase("case_15");
//		runService.TestReportRemarks("验证在设置交易密码界面,输入对应交易密码后,可以正常设置成功,并进入设置交易密码成功界面");
//	}
//	
//	@Test
//	public void case_16() throws Exception{
//		runService.runCase("case_16");
//		runService.TestReportRemarks("验证在个人中心界面,进入数据库根据用户ID修改对应可用额度后,可用正常新增可消费额度");
//	}
	
	@AfterTest
	public void TearDown(){
		runService.closeApp();
	}
}
