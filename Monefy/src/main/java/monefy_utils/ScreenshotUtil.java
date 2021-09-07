package monefy_utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import monefy_tests.Testbase;

public class ScreenshotUtil implements ITestListener {
	private static Logger log = LogManager.getLogger(ScreenshotUtil.class);
	
	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
		captureScreenShot(result, "PASS");
		log.info("Screenshot captured for Pass");

	}

	public void onTestFailure(ITestResult result) {
		captureScreenShot(result, "FAIL");
		log.info("Screenshot captured for Failure");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	// Function to capture screenshot.
	public String captureScreenShot(ITestResult result, String status) {
		final WebDriver augmentedDriver = Testbase.getScreenshotableWebDriver();
		String destDir = "C:/monefy/Screenshots";
		String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "."
				+ result.getMethod().getMethodName();
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		// To create folder to store screenshots
		new File(destDir).mkdirs();
		// Set file name with combination of test class name + date time.
		String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";
		log.info("Saving Screenshot to : " +destFile );
		
		try {
			// Store file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Exception occured in copying screenshot from + "+ scrFile +" to "+ destDir + "/" + destFile);
		}
		
		return destFile;
	}

}
