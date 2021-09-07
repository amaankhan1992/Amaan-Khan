package monefy_utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * This class generates the extent report
 * @author amaankhan
 *
 */
public class ExtentReporter implements IReporter {
	private ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	ScreenshotUtil screenshotUtil;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		String destDir = "C:/monefy/Report/";
		String reportName="monefy_Report.html";
		htmlReporter = new ExtentHtmlReporter(destDir+reportName);
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				try {
					buildTestNodes(context.getPassedTests(), Status.PASS);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getFailedTests(), Status.FAIL);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getSkippedTests(), Status.SKIP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		extent.flush();

	}
	


	private void buildTestNodes(IResultMap tests, Status status) throws IOException {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getMethod().getMethodName());

				/*
				 * test.getTest(). = getTime(result.getStartMillis());
				 * test.getTest().endedTime = getTime(result.getEndMillis());
				 */

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				String message = "Test "+result.getMethod().getMethodName()+ " " + status.toString().toLowerCase() + "ed";

				if (result.getThrowable() != null)
					message = result.getThrowable().getMessage();

				test.log(status, message);
				DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
				test.addScreenCaptureFromPath("C:/monefy/Screenshots", "Screenshot"+dateFormat);
		
				// extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
