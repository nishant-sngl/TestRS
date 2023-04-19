package ns;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import ns.resources.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListeners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports reports = Reports.getReport();
    ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart" + result.getTestName());
        test = reports.createTest(result.getMethod().getMethodName());
        exTest.set(test);
        exTest.get().log(Status.INFO, "starting");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess" + result.getTestName());
        exTest.get().log(Status.INFO, "passed");
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriver");
        try {
            String file = takeScreenshot(result.getMethod().getMethodName(),driver);
            exTest.get().addScreenCaptureFromPath(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure" + result.getTestName());
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
        reports.flush();
    }
}
