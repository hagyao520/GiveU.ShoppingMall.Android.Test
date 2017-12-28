package JYQBTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.AndroidTestXmlParse_Service;

public class JYQB_Shopping {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	private void stup() throws Exception{
		Test_Unit testunit = AndroidTestXmlParse_Service.parse2("src/main/java/JYQBTestCaseXml/JYQB_Shopping.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【即有钱包商城购物流程的测试场景点】-----------------------------------");
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
		runService.TestReportRemarks("验证在首页购物界面,点击顶部搜索商品栏,输入对应商品信息后,可以正常搜索出对应商品信息");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在商品搜索界面,选择对应商品点击后,可以正常进入商品购买界面");
	}
	
	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("验证在商品购买界面,选择对应地址,点击立即购买按钮后,可以正常进入选择商品版本和颜色界面");
	}

	@Test
	public void case4() throws Exception{
		runService.runCase("case4");
		runService.TestReportRemarks("验证在选择商品版本和颜色界面,选择对应商品版本和颜色,点击下一步按钮后,可以正常进入选择商品支付方式和分期数界面");
	}
	
	@Test
	public void case5() throws Exception{
		runService.runCase("case5");
		runService.TestReportRemarks("验证在选择商品支付方式和分期数界面,选择对应支付方式,首付和分期数,点击确认按钮后,可以正常进入订单信息确认界面");
	}
	
	@Test
	public void case6() throws Exception{
		runService.runCase("case6");
		runService.TestReportRemarks("验证在订单信息确认界面,点击收货地址区域选项后,可以正常进入选择收货地址界面");
	}
	
	@Test
	public void case7() throws Exception{
		runService.runCase("case7");
		runService.TestReportRemarks("验证在选择收货地址界面,点击添加收货地址按钮,选择输入对应收货地址信息,点击保存按钮后,可以正常保存添加成功");
	}
	
	@Test
	public void case8() throws Exception{
		runService.runCase("case8");
		runService.TestReportRemarks("验证在选择收货地址界面,选择对应添加的收货地址后,可以正常选择,并返回订单信息确认界面");
	}
	
	@Test
	public void case9() throws Exception{
		runService.runCase("case9");
		runService.TestReportRemarks("验证在订单信息确认界面,勾选已阅读并同意消费分期合同选项,点击去支付按钮后,可以正常弹出请输入交易密码界面");
	}
	
	@Test
	public void case_10() throws Exception{
		runService.runCase("case_10");
		runService.TestReportRemarks("验证在请输入交易密码界面,输入对应交易密码后,可以正常进入验证绑定手机界面");
	}
	
	@Test
	public void case_11() throws Exception{
		runService.runCase("case_11");
		runService.TestReportRemarks("验证在验证绑定手机界面,输入对应验证码后,可以正常进入订单支付成功界面");
	}
	
	@Test
	public void case_12() throws Exception{
		runService.runCase("case_12");
		runService.TestReportRemarks("验证在订单支付成功界面,点击查看订单按钮后,可以正常进入我的订单界面");
	}
	
	@Test
	public void case_13() throws Exception{
		runService.runCase("case_13");
		runService.TestReportRemarks("验证在我的订单界面,购买商品成功后,可以正常显示购买的商品,且对应订单状态和商品信息显示正确");
	}
	
	@Test
	public void case_14() throws Exception{
		runService.runCase("case_14");
		runService.TestReportRemarks("验证在我的订单界面,选择对应订单,点击确认收货按钮后,可以正常收货成功,且订单状态和对应状态的按钮显示正确");
	}
		
	@AfterTest
	public void TearDown(){
		runService.closeApp();
	}
}
