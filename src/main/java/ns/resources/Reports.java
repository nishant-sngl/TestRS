package ns.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

    static ExtentSparkReporter reporter;
    static ExtentReports report;

    public static ExtentReports getReport(){
        String path = System.getProperty("user.dir") + "/reports/index.html";
        reporter = new ExtentSparkReporter(path);
        report = new ExtentReports();
        report.attachReporter(reporter);
        return report;
    }
}
