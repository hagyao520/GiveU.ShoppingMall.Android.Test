package com.dafycredit.giveu.test.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;

import com.dafycredit.giveu.test.handler.AndroidSystem_Handler;
import com.dafycredit.giveu.test.handler.CheckAction_Handler;
import com.dafycredit.giveu.test.handler.ClearAction_Handler;
import com.dafycredit.giveu.test.handler.ClickAction_Handler;
import com.dafycredit.giveu.test.handler.DBAction_Handler;
import com.dafycredit.giveu.test.handler.GetUrlAction_Handler;
import com.dafycredit.giveu.test.handler.InputAction_Handler;
import com.dafycredit.giveu.test.handler.WindowsSystem_Handler;
import com.dafycredit.giveu.test.handler.RecordAction_Handler;
import com.dafycredit.giveu.test.handler.SlideAction_Handler;
import com.dafycredit.giveu.test.handler.WaitAction_Handler;
import com.dafycredit.giveu.test.util.Appium_Util;

public enum Step_Action {
	
    SET("set", "设置值到全局"){
		@Override
		public void run(Test_Step step) throws Exception {
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">" + Appium_Util.localmap.toString());
			step.getAndroidDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			if(StringUtils.isBlank(step.getDetails().get("key")))
				throw new Exception("set操作必须设置保存结果的键值，供后续操作使用，例子为details='key:credit'！");
			String value = Appium_Util.getElement(step).getText();
			Appium_Util.localmap.put(step.getDetails().get("key").toUpperCase(), value);
//			System.out.println("SrepAction: " + Appium_Util.localmap.toString());
		}
	},
    
    WEB_GETURL("web-geturl", "Web端打开网站链接操作", GetUrlAction_Handler.class),
    ANDROID_GETURL("android-geturl", "Android端打开网站链接操作", GetUrlAction_Handler.class),
    
    WINDOWS_KEYBG("windows-keybg", "模拟点击Windows系统键盘普通按键,例如：Home键", WindowsSystem_Handler.class),
    WINDOWS_KEYBC("windows-keybc", "模拟点击Windows系统键盘组合按键,例如：Ctrl+W", WindowsSystem_Handler.class),
    WINDOWS_SKEYBC("windows-skeybc", "模拟点击Windows系统键盘特殊组合按键,例如：Ctrl+Tab", WindowsSystem_Handler.class),
    WINDOWS_SKEYBCM("windows-skeybcm", "模拟点击Windows系统键盘多重特殊组合按键,例如：Ctrl+Shift+K", WindowsSystem_Handler.class),
    WINDOWS_STCNW("windows-stcnw", "模拟操作切换浏览器到当前最新窗口", WindowsSystem_Handler.class),
    WINDOWS_CMD("windows-cmd", "模拟执行Windows系统的cmd命令", WindowsSystem_Handler.class),
    
    ANDROID_KEYCODE("android-keycode", "模拟Android系统键盘按键操作,例如：KEYCODE_HOME 3", AndroidSystem_Handler.class),
    ANDROID_RETURN("android-return", "模拟Android系统返回按键操作,可返回多次", AndroidSystem_Handler.class),
    ANDROID_OPENNB("android-opennb", "模拟打开Androud系统通知栏操作", AndroidSystem_Handler.class),
    ANDROID_SCROLL("android-scroll", "模拟执行Androud系统页面滚动操作", AndroidSystem_Handler.class),
    ANDROID_SWIPE("android-swipe", "模拟执行Androud系统页面滑动操作", AndroidSystem_Handler.class),
    ADB_SWIPE("adb-swipe", "模拟执行ADB指令页面滑动操作", AndroidSystem_Handler.class),
    
    WEB_CLEAR("web-clear", "Web端清除操作", ClearAction_Handler.class),
    ANDROID_CLEAR("android-clear", "Android端清除操作", ClearAction_Handler.class),
    
    WEB_INPUT("web-input", "Web端输入操作", InputAction_Handler.class),
    ANDROID_INPUT("android-input", "Android端Appium输入操作", InputAction_Handler.class),
    ADB_INPUT("adb-input", "Android端ADB输入操作", InputAction_Handler.class),
    
    WEB_CHECK("web-check", "检查Web界面元素值", CheckAction_Handler.class),
    WEB_CHECKLIST("web-checklist", "检查Web本地缓存的list中的元素", CheckAction_Handler.class),
    ANDROID_CHECK("android-check", "检查Android界面元素值", CheckAction_Handler.class),
    ANDROID_CHECKLIST("android-checklist", "检查Android本地缓存的list中的元素", CheckAction_Handler.class),
    
    WAIT_FORCED("wait-forced", "强制等待", WaitAction_Handler.class),
    WEBWAIT_IMPLICIT("web-implicit", "Web端隐式等待", WaitAction_Handler.class),
    ANDROIDWAIT_IMPLICIT("android-implicit", "Android端隐式等待", WaitAction_Handler.class),
    
    WEB_CLICK("web-click", "Web端点击操作", ClickAction_Handler.class),
    ANDROID_CLICK("android-click", "Android端点击操作", ClickAction_Handler.class),
    SELECT_CLICK("select-click", "Web端选项框点击操作", ClickAction_Handler.class),
    CLICK_OK("click-ok", "点击浏览器弹出框的确定键", ClickAction_Handler.class),
    CLICK_CANCEL("click-cancel", "点击浏览器弹出框的取消键", ClickAction_Handler.class),
    CLICK_TEXT("click-text", "执行浏览器文本弹出框的文本输入", ClickAction_Handler.class),
      
    START_RECORD("start-record", "开始录制视频",RecordAction_Handler.class),
    END_RECORD("end-record", "结束录制视频",RecordAction_Handler.class),
    PNLL_RECORD("pull-record", "上传录制的视频",RecordAction_Handler.class),
    MOVE_RECORD("move-record", "移动录制的视频",RecordAction_Handler.class),
    
    SLIDE("slide", "自定义滑动", SlideAction_Handler.class),
    SLIDE_UP("slide-up", "向上滑动", SlideAction_Handler.class),
    SLIDE_DOWN("slide-down", "向下滑动", SlideAction_Handler.class),
    SLIDE_LEFT("slide-left", "向左滑动", SlideAction_Handler.class),
    SLIDE_RIGHT("slide-right", "向右滑动", SlideAction_Handler.class),
    
	DB_QUERY("db-query", "Oracle数据库查询", DBAction_Handler.class),
    DB_UPDATE("db-update", "Oracle数据库更新", DBAction_Handler.class),
    DB_DELETE("db-delete", "Oracle数据库删除", DBAction_Handler.class),
    DB_INSERT("db-insert", "Oracle数据库插入", DBAction_Handler.class),
	DB_PROCEDURE("db-procedure", "Oracle数据库存储过程", DBAction_Handler.class),
	
	DB_QUERYM("db-querym", "MySql数据库查询", DBAction_Handler.class),
    DB_UPDATEM("db-updatem", "MySql数据库更新", DBAction_Handler.class),
    DB_DELETEM("db-deletem", "MySql数据库删除", DBAction_Handler.class),
    DB_INSERTM("db-insertm", "MySql数据库插入", DBAction_Handler.class),
	DB_PROCEDUREM("db-procedurem", "MySql数据库存储过程", DBAction_Handler.class);
	
    private String key;

    private String desc;

    private Class<?> handler;

    private static Map<String,Step_Action> map;

    static{
        map = new HashMap<String,Step_Action>();
        for(Step_Action action : Step_Action.values()){
            map.put(action.key(), action);
        }
    }

    private Step_Action(String key, String desc, Class<?> handler) {
        this(key, desc);
        this.handler = handler;
    }

    private Step_Action(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static Step_Action action(String name){
        return map.get(name);
    }

    public String key(){
        return this.key;
    }

    public String desc(){
        return this.desc;
    }

    public Class<?> handler(){
        return this.handler;
    }
    
    public void run(Test_Step step) throws Exception{
    	
    }
}
