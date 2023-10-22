package mayurprac;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.osa.genericUtils.BaseClass;
import com.osa.genericUtils.WebDriverUtility;

public class ListenerImplementationPrac implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"  Execution is started");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"Execution is success");
		Reporter.log(methodName+"Execution is completed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String failscript=WebDriverUtility.takeScreenShot(BaseClassMayurPrac.sdriver, "FromPracSS");
		test.addScreenCaptureFromPath(failscript);
		test.log(Status.FAIL,result.getThrowable());
		test.log(Status.FAIL, methodName+"Execution is failed");
		Reporter.log(methodName+"Execution is failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,result.getThrowable());
		test.log(Status.SKIP, methodName +"Execution is skipped");
		Reporter.log(methodName+"execution is skipped");
	}
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Ex.html");
		htmlreport.config().setDocumentTitle("Mayur");
		htmlreport.config().setReportName("OnlineShoppingApplication");
		htmlreport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Window 11");
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-URL", "http://www.localhost.com");
		report.setSystemInfo("Reporter Name", "Mayur");
		
	}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
}
