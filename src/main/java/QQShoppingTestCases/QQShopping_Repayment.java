package QQShoppingTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.AndroidTestXmlParse_Service;

public class QQShopping_Repayment {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	private void stup() throws Exception{
		Test_Unit testunit = AndroidTestXmlParse_Service.parse3("src/main/java/QQShoppingTestCaseXml/QQShopping_Repayment.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【即有钱包QQ购物还款流程的测试场景点】-----------------------------------");
	}
		
	@Test
	public void Precondition() throws Exception{
		runService.runCase("前置条件");
		runService.TestReportRemarks("验证在数据库中,执行对应SQL语句,可以正常执行成功");
	}

	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("验证在购物主界面,点击还款模块选项后,可以正常进入还款界面");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在还款界面,点击下期应还,选择对应分期产品,输入对应还款金额,点击确定还款按钮确定后,可以正常还款成功,并进入还款成功界面");
	}
	
	@AfterTest
	public void TearDown(){
		runService.closeApp();
	}
}
