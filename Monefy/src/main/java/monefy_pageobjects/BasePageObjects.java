package monefy_pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import monefy_utils.PropertyUtils;
import monefy_utils.WaitUtils;

public class BasePageObjects {
	public static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
	WaitUtils waitUtils;
    protected final AndroidDriver<AndroidElement> androidDriver;
    private static Logger log = LogManager.getLogger(BasePageObjects.class);
    
    public BasePageObjects(AndroidDriver<AndroidElement> driver ) {
		
		this.androidDriver = driver;
		initElements();
		waitUtils=new WaitUtils();
	}


	private void initElements() {
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		log.info("Page factory Elements initialised successfully");
	}
    
	
}
