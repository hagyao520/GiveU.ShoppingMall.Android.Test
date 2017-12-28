package JYQBTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.AndroidTestXmlParse_Service;

public class JYQB_Enchashment {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	private void stup() throws Exception{
		Test_Unit testunit = AndroidTestXmlParse_Service.parse2("src/main/java/JYQBTestCaseXml/JYQB_Enchashment.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【即有钱包取现流程的测试场景点】-----------------------------------");
	}
		
	@Test
	public void Precondition() throws Exception{
		runService.runCase("前置条件");
		runService.TestReportRemarks("验证在数据库中,执行对应SQL语句,可以正常执行成功");
	}

	@Test
	public void case0() throws Exception{
		runService.runCase("case0");
		runService.TestReportRemarks("单条用例测试的前置条件");
	}
	
	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("验证在个人中心界面,点击取现模块选项后,可以正常进入我要取现界面");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在我要取现界面,点击立即借款按钮后,可以正常进入取现借款界面");
	}
	
	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("验证在取现借款界面,选择输入对应提款额和分期数,点击确定按钮后,可以正常进入输入交易密码界面");
	}

	@Test
	public void case4() throws Exception{
		runService.runCase("case4");
		runService.TestReportRemarks("验证在输入交易密码界面,输入对应交易密码后,可以正常进入验证绑定手机界面");
	}
	
	@Test
	public void case5() throws Exception{
		runService.runCase("case5");
		runService.TestReportRemarks("验证在验证绑定手机界面,输入对应验证码后,可以正常取现成功,并进入取现成功界面");
	}
	
	@Test
	public void case6() throws Exception{
		runService.runCase("case6");
		runService.TestReportRemarks("验证在取现成功界面,点击查看放款进度按钮后,可以正常进入取现记录界面");
	}
	
	@Test
	public void case7() throws Exception{
		runService.runCase("case7");
		runService.TestReportRemarks("验证在取现记录界面,对应取现记录显示正确,包含(金额,状态，类型,时间)");
	}
	
	@AfterTest
	public void TearDown(){
		runService.closeApp();
	}
}
