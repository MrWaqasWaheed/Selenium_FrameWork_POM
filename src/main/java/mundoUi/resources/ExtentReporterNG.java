package mundoUi.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		// Create an instance of ExtentSparkReporter helper class for extent main class
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Merl Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Waqas Waheed");
		return extent;

	}
}
