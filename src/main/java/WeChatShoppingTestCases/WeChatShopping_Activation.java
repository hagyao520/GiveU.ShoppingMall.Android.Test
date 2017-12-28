package WeChatShoppingTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.AndroidTestXmlParse_Service;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.WebTestXmlParse_Service;

public class WeChatShopping_Activation {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	private void stup() throws Exception{
		Test_Unit testunit = AndroidTestXmlParse_Service.parse3("src/main/java/WeChatShoppingTestCaseXml/WeChatShopping_Activation.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【即有钱包微信购物激活流程的测试场景点】-----------------------------------");
	}
		
	@Test
	public void Precondition() throws Exception{
		runService.runCase("前置条件");
		runService.TestReportRemarks("验证在数据库中,执行对应SQL语句,可以正常执行成功");
	}

	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("验证在Android系统谷歌浏览器中,打开即有钱包激活网址,可以正常进入即有钱包激活界面");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在激活界面,输入对应用户身份信息,选择对应平台,点击同意协议并授权按钮后,可以正常激活成功,并进入即有钱包购物主界面");
	}

	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("验证在首页购物界面,对应用户的总额度信息显示正确");
	}
	
	@AfterTest
	public void TearDown(){
		runService.closeApp();
	}
}
