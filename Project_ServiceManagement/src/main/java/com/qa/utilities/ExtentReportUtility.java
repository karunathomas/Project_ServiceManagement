package com.qa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports=new ExtentReports();
	// at a time only single thread can access for that synchronized is used
	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreports/extent-report.html"); 
        reporter.config().setReportName(" Extent Report");      
        extentReports.attachReporter(reporter); 
        extentReports.setSystemInfo("company Name", "Service Management");     
        extentReports.setSystemInfo("Author", " Karuna");     
        return extentReports;
	}
}
