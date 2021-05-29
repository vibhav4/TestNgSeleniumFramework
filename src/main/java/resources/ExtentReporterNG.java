package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    ExtentReports extent;

    public ExtentReports getReportObject(){
        // Extyent report . Extent sparkreporter
        String rpath = System.getProperty("user.dir") + "/reports/index.html";
        System.out.println(rpath);
        ExtentSparkReporter reporter = new ExtentSparkReporter(rpath);
        reporter.config().setReportName("Vibhav Automation Results");
        reporter.config().setDocumentTitle("SetResults");


        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Vibhav Sharma");
        return extent;
    }
}
