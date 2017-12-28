package ETest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.AndroidTestXmlParse_Service;

public class Main {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	private static void stup() throws Exception{
		Test_Unit testunit = AndroidTestXmlParse_Service.parse("src/main/java/TestCaseXml/P2P_PPM_Mobile_SeriesA.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【P2P_PPM模式下购买手机系列A产品的测试场景点】-----------------------------------");
	}
		
	@Test
	public static void Precondition() throws Exception{
		runService.runCase("前置条件");
		runService.TestReportRemarks("验证在数据库中,执行对应SQL语句,可以正常执行成功");
	}

	@Test
	public static void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("验证在Android中,首次安装启动即有宝APP后,引导页显示正常且可以滑动至最后一页");
	}
	
	@Test
	public static void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在引导页最后一页界面,点击开始体验按钮后,可以正常进入登录界面");
	}
	
	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("验证在登录界面,输入正确的账号和密码,已连接网络和开启GPS定位权限时,点击登录按钮后,可以正常登录并进入设置解锁密码界面");
	}

	@Test
	public void case4() throws Exception{
		runService.runCase("case4");
		runService.TestReportRemarks("验证在新建订单界面,选择输入对应产品信息,点击下一步按钮后,可以正常进入产品列表界面");
	}
	
	@Test
	public void case5() throws Exception{
		runService.runCase("case5");
		runService.TestReportRemarks("验证在产品列表界面,选择对应产品信息,点击下一步按钮后,可以正常进入商品信息界面");
	}
	
	@Test
	public void case6() throws Exception{
		runService.runCase("case6");
		runService.TestReportRemarks("验证在商品信息界面,选择输入对应商品信息,点击下一步按钮后,可以正常进入客户信息界面");
	}
	
	@Test
	public void case7() throws Exception{
		runService.runCase("case7");
		runService.TestReportRemarks("验证在客户信息界面,上传输入对应客户身份证正反面照片信息,点击生成订单按钮后,可以正常进入基本信息界面");
	}
	
	@Test
	public void case8() throws Exception{
		runService.runCase("case8");
		runService.TestReportRemarks("验证在基本信息界面,选择输入对应客户基本信息,点击下一步按钮后,可以正常进入单位信息界面");
	}
	
	@Test
	public void case9() throws Exception{
		runService.runCase("case9");
		runService.TestReportRemarks("验证在单位信息界面,选择输入对应客户单位信息,点击下一步按钮后,可以正常进入联系人填写界面");
	}
	
	@Test
	public void case_10() throws Exception{
		runService.runCase("case_10");
		runService.TestReportRemarks("验证在联系人填写界面,选择输入对应客户联系人信息,点击下一步按钮后,可以正常进入绑定银行卡界面");
	}
	
	@Test
	public void case_11() throws Exception{
		runService.runCase("case_11");
		runService.TestReportRemarks("验证在绑定银行卡界面,输入对应客户银行卡信息,点击下一步按钮后,可以正常进入其他信息界面");
	}
	
	@Test
	public void case_12() throws Exception{
		runService.runCase("case_12");
		runService.TestReportRemarks("验证在其他信息界面,输入对应客户其他信息,点击下一步按钮后,可以正常进入芝麻信用认证界面");
	}
	
	@Test
	public void case_13() throws Exception{
		runService.runCase("case_13");
		runService.TestReportRemarks("验证在芝麻信用认证界面,点击跳过认证按钮后,可以正常跳过认证并进入运营商授权认证界面");
	}
	
	@Test
	public void case_14() throws Exception{
		runService.runCase("case_14");
		runService.TestReportRemarks("验证在运营商授权认证界面,点击跳过认证按钮后,可以正常跳过认证并进入影像证明界面");
	}
		
	@Test
	public void case_15() throws Exception{
		runService.runCase("case_15");
		runService.TestReportRemarks("验证在影像证明界面,上传对应客户影像证明照片,点击确认提交按钮后,可以正常弹出请输入登录密码,以验证身份界面");
	}
	
	@Test
	public void case_16() throws Exception{
		runService.runCase("case_16");
		runService.TestReportRemarks("验证在请输入登录密码,以验证身份界面,输入对应用户登录密码,点击确认按钮后,可以正常提交合同并进入成功提交界面");
	}
	
	@Test
	public void case_17() throws Exception{
		runService.runCase("case_17");
		runService.TestReportRemarks("验证在成功提交界面,点击查看订单按钮后,可以正常进入订单列表-审核中列界面");
	}
	
	@Test
	public void case_18() throws Exception{
		runService.runCase("case_18");
		runService.TestReportRemarks("验证在审核中列界面,进入数据库修改对应合同状态为审核通过后,可以自动改变合同状态并进入审核通过列");
	}
	
	@Test
	public void case_19() throws Exception{
		runService.runCase("case_19");
		runService.TestReportRemarks("验证在审核通过列界面,选择对应合同点击补传资料按钮后,可以正常进入补传资料界面");
	}
	
	@Test
	public void case_20() throws Exception{
		runService.runCase("case_20");
		runService.TestReportRemarks("验证在补传资料界面,输入上传对应手机串号和IMEI码照片,点击确认提交按钮后,可以正常提交成功并返回审核通过列界面,且出现确认注册按钮");
	}
	
	@Test
	public void case_21() throws Exception{
		runService.runCase("case_21");
		runService.TestReportRemarks("验证在审核通过列界面,点击签字按钮后,可以正常进入短信签章界面");
	}

	@Test
	public void case_22() throws Exception{
		runService.runCase("case_22");
		runService.TestReportRemarks("验证在短信签章界面,点击获取验证码按钮后,可以正常发送且输入对应验证码后,可以正常提交成功并返回审核通过列界面,且出现绑定微信按钮");
	}
	
	@Test
	public void case_23() throws Exception{
		runService.runCase("case_23");
		runService.TestReportRemarks("验证在PDF列表界面,短信签章成功后,签章类型显示正确,且可以生成对应PDF合同,包含(商品分期确认书,消费贷款申请表,服务须知,贷款合同,还款须知,消费咨询服务合同,参保须知)");
	}
	
	@Test
	public void case_24() throws Exception{
		runService.runCase("case_24");
		runService.TestReportRemarks("验证在审核通过列界面,点击确认注册按钮后,可以正常注册成功,且改变合同状态为已注册");
	}
	
	@Test
	public void case_25() throws Exception{
		runService.runCase("case_25");
		runService.TestReportRemarks("验证在已注册列界面,进入数据库根据合同ID执行存储过程后,可以自动改变合同状态并进入现行列");
	}
	
	@Test
	public void case_26() throws Exception{
		runService.runCase("case_26");
		runService.TestReportRemarks("验证在现行列界面,进入数据库根据合同号查询后,该合同属于P2P_PPM合作模式");
	}

	@AfterTest
	public static void TearDown(){
		runService.closeApp();
	}

	public static void main(String[] args) throws Exception {
		  stup();
		  Precondition();
//		  case1();
//		  case2();
		  TearDown();
    } 
}
