package Academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import resources.ExtentReporterNG;
//import resources.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    ExtentReporterNG ex = new ExtentReporterNG();
    ExtentReports extent = ex.getReportObject();
    ExtentTest test;

    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
         test = extent.createTest(result.getMethod().getMethodName());
         extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();
        try {
            driver =  (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
//            extentTest.get().
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),result.getMethod().getMethodName());
//            getScreenShotPath(testMethodName,driver);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
