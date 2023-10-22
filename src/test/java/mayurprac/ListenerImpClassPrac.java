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

public class ListenerImpClassPrac  implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" testscript passed");
		Reporter.log(methodName+" executed succeessfully");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String failedscript = WebDriverUtility.takeScreenShot(BaseClass.sdriver, methodName);
		test.addScreenCaptureFromPath(failedscript);
		test.log(Status.FAIL,result.getThrowable());
		test.log(Status.FAIL, methodName+"Is failed");
		Reporter.log(methodName+"is execution failed");
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "testscript is skipped");
		Reporter.log(methodName+"testscript is skipped");
	}
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./Reporter/report.html");
		htmlreport.getConf().setDocumentTitle("OSA");
		htmlreport.getConf().setReportName("Online shopping application");
		htmlreport.getConf().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.setSystemInfo("OS", "window");
		report.setSystemInfo("browser", "chrome");
		report.setSystemInfo("baseurl", "http://rmgtestingsever");
		report.setSystemInfo("reporter name", "mayur");
		
		
	}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
}
