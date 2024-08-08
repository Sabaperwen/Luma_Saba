package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestListenerImplClass implements ITestListener{
 ExtentReports report;
 ExtentTest test;
 PropertyFileUtility pf=new PropertyFileUtility();
	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"---------"+"execution start from here");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName);
		Reporter.log(methodName+"------------"+"successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+"------------Failed"); 
		test.log(Status.FAIL,result.getThrowable());
		try {
		String screenShotNa = WebDriverUtility.takesScreenShot(BaseClass.driver, methodName);
		test.addScreenCaptureFromPath(screenShotNa);
		} catch (IOException e) {
			// TODO Auto-generat ed catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
    String methodName=result.getMethod().getMethodName();
    test.log(Status.SKIP, methodName+"--------------"+"skipped");
    Reporter.log(methodName+" "+"----------Skipped");
    test.log(Status.FAIL, result.getThrowable()); 
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter html=new ExtentSparkReporter("./screenshot/extentReport.html");
		html.config().setDocumentTitle("Luma");
		html.config().setReportName("LUMA");
		html.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("BasePlatform","Window 10");
		report.setSystemInfo("ReporterName", "Saba");
		
		
		try {
			report.setSystemInfo("BaseURL",pf.readDataFromPropertyFile("URL"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
