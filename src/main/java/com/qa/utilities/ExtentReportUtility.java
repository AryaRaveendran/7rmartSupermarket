package com.qa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	static ExtentReports extent;
	public static ExtentReports getReportObject() {
		String path =System.getProperty("user.dir")+"\\reports\\ExtentReport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Arya");
		reporter.config().setDocumentTitle("Automation execution report");

		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS:", "Windows");
		return extent;

	}

}
