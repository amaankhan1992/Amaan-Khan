package monefy_tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import monefy_utils.PropertyUtils;
import monefy_utils.WaitUtils;

/**
 * base class for setting up appium driver
 * 
 * @author amaankhan
 *
 */

public abstract class Testbase {

	/**
	 * Appium Driver and wait properties
	 */
	public static AndroidDriver<AndroidElement> driver;
	public static String APPIUM_SERVER_URL = PropertyUtils.getProperty("appium.server.url",
			"http://127.0.0.1:4723/wd/hub");
	public static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
	public static WaitUtils waitUtils = new WaitUtils();
	private static Logger log = LogManager.getLogger(Testbase.class);

	/**
	 * This method will run at the time of Test Suite creation so it will run at
	 * once through out the execution
	 * 
	 * @param method
	 *
	 **/
	@BeforeMethod
	public void setUpAppium() throws MalformedURLException {
		log.info("Setting up appium");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		setDesiredCapabilitiesForAndroid(capabilities);
		driver = new AndroidDriver<AndroidElement>(new URL(APPIUM_SERVER_URL), capabilities);

		log.info("Driver Started");
	}

	/**
	 * This method will be called everytime before your test runs
	 */
	@BeforeTest
	public abstract void setUpPage();

	/**
	 * This method will always execute after each test case, This will quit the
	 * WebDriver instance called at the last
	 */
	@AfterMethod(alwaysRun = true)
	public void afterMethod(final ITestResult result) throws IOException {
		String fileName = result.getTestClass().getName() + "_" + result.getName();
		log.info("Test Case: [" + fileName + "] executed..!");
	}

	/**
	 * This method will be called after class finishes the execution of all
	 * tests
	 */
	@AfterClass
	public void afterClass() {
	}

	/**
	 * At the end of the Test Suite(At last) this method would be called
	 */
	@AfterSuite
	public void tearDownAppium() {
		quitDriver();
	}

	public static WebDriver getScreenshotableWebDriver() {
		final WebDriver augmentedDriver = new Augmenter().augment(driver);
		return augmentedDriver;
	}

	/**
	 * This will set implicit wait
	 *
	 * @param driver
	 */
	private static void setTimeOuts(AppiumDriver driver) {
		// Use a higher value if your mobile elements take time to show up
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.info("Setting implicit Wait");
	}

	private static String getAbsolutePath(String appRelativePath) {
		File file = new File(appRelativePath);
		return file.getAbsolutePath();
	}

	/**
	 * It will set the DesiredCapabilities for the local execution
	 *
	 * @param desiredCapabilities
	 */
	private void setDesiredCapabilitiesForAndroid(DesiredCapabilities desiredCapabilities) {
		log.info("Setting Desired Capabilities for the driver.");
		String PLATFORM_NAME = PropertyUtils.getProperty("android.platform");
		String PLATFORM_VERSION = PropertyUtils.getProperty("android.platform.version");
		String APP_NAME = PropertyUtils.getProperty("android.app.name");
		String APP_RELATIVE_PATH = PropertyUtils.getProperty("android.app.location") + APP_NAME;
		String APP_PATH = getAbsolutePath(APP_RELATIVE_PATH);
		String DEVICE_NAME = PropertyUtils.getProperty("android.device.name");
		String APP_PACKAGE_NAME = PropertyUtils.getProperty("android.app.packageName");
		String APP_ACTIVITY_NAME = PropertyUtils.getProperty("android.app.activityName");
		String APP_FULL_RESET = PropertyUtils.getProperty("android.app.full.reset");
		String APP_NO_RESET = PropertyUtils.getProperty("android.app.no.reset");

		log.info("Setting Capabilities as " + PLATFORM_NAME + ", " + PLATFORM_VERSION + ", " + APP_NAME + ", " + APP_PATH
				+ ", "+DEVICE_NAME+ ", "+ APP_PACKAGE_NAME+ ", "+ APP_FULL_RESET+ ", "+ APP_NO_RESET);
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		desiredCapabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_NAME);
		desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, APP_FULL_RESET);
		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, APP_NO_RESET);
		// desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,
		// true);
	}

	/**
	 * This will quite the android driver instance
	 */
	private void quitDriver() {
		try {
			driver.quit();
			log.info("Driver Closed");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}

}
