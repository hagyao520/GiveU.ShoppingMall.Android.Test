package JYQBTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.AndroidTestXmlParse_Service;

public class JYQB_Repayment {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	private void stup() throws Exception{
		Test_Unit testunit = AndroidTestXmlParse_Service.parse2("src/main/java/JYQBTestCaseXml/JYQB_Repayment.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【即有钱包还款流程的测试场景点】-----------------------------------");
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
		runService.TestReportRemarks("验证在我要取现界面,点击还款模块选项后,可以正常进入还款界面");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在还款界面,选择对应分期产品,输入对应还款金额,点击确定还款按钮确定后,可以正常进入微信支付界面");
	}
	
	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("验证在微信支付界面,点击立即支付按钮,输入对应支付密码后,可以正常支付成功,并进入支付成功界面");
	}

	@Test
	public void case4() throws Exception{
		runService.runCase("case4");
		runService.TestReportRemarks("验证在支付成功界面,点击返回即有分期按钮后,可以正常返回至还款界面");
	}
	
	@AfterTest
	public void TearDown(){
		runService.closeApp();
	}
}
