package com.osa.genericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName + "---> Execution starts");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName + "---->passed");
		Reporter.log(methodName + "------> Testscript executed successfully");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String failedscript = WebDriverUtility.takeScreenShot(BaseClass.sdriver, "OSAScreenshot");
		test.addScreenCaptureFromPath(failedscript);
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, methodName);
		Reporter.log(methodName + "-----> Failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodName + "----> Skipped");
		Reporter.log(methodName + "--->Skipped");
	}
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("OSA");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Online Shopping Application");

		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "window-11");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		report.setSystemInfo("Reporter Name", "Mayur");
	}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
