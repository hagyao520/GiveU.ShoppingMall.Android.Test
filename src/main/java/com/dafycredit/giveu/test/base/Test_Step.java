package com.dafycredit.giveu.test.base;

import java.util.Map;

/**
 * <br>对应于XML文件中的step元素</br>
 *
 * @version 1.0
 * @since   1.0
 */
public class Test_Step extends Test_Base{
	
	/**
	 * 当前步骤的行为
	 */
	private Step_Action action;

	/**
	 * 行为的细节描述，其格式与css中的样式格式一致，比如<br/>
	 * 在要做滑动操作时，细节描述如下，range代表滑动时间，num代表滑动次数：
	 * <h1>range:500;num:1;</h1>
	 * 具体不同的操作的文档会在项目稳定后整理出来
	 */
	private Map<String,String> details;
	
	/**
	 * 获取Android系统按键信息,通过键值获取，例子如下：<br/>
	 * <h1>key:3;</h1>
	 */
//	private Map<String,String> detailse;
	
	/**
	 * <br>根据配置取界面上的元素，约定获取界面元素的描述如下：<br/>
	 * <h1>属性名=属性值[索引]</h1><br/>
	 * 如果属性可以唯一确定要获取的元素，则可以省略[索引]，例子如下：<br/>
	 * class=android.widget.TextView[1]
	 */
	private String locator;

	/**
	 * 获取键盘Key值
	 */
    private String key;
	
    /**
	 * 获取键盘Keys值
	 */
	private String keys;
	
	/**
	  * 输入框中的输入值或者数据库操作sql等
	 */
	private String value;
	
	/**
	 * 当前的步骤失败时的截图，一般同用例名称
	 */
	private String screenshot;
	
	/**
	 * 当前操作后用于记录到报告中的消息.
	 */
	private String message;
	
    public Step_Action getAction() {
        return action;
    }

    public void setAction(Step_Action action) {
        this.action = action;
    }

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public Map<String,String> getDetails() {
		return details;
	}

	public void setDetails(Map<String,String> detail) {
		this.details = detail;
	}
	
	public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
    
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getScreenshot() {
		return screenshot;
	}

	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "TestStep [action=" + action + ", details=" + details + ", locator=" + locator + ", value=" + value
				+ ", screenshot=" + screenshot + ", message=" + message + "]";
	}
}
