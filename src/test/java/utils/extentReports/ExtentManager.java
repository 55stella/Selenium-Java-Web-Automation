package utils.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/project-report.html");
        reporter.config().setReportName("FE APP ");
        reporter.config().setDocumentTitle("FE report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Stella Agbadu");
        return extentReports;
    }
}
