package com.mystore.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.ReportStats;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManeger {

	
	ExtentSparkReporter htmlReporter ;
	 ExtentReports reports ;
	ExtentTest test ;
	
	public void startReport() throws IOException {
		
		htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\test-output\\ExtentReport\\" + "myExtentReport_AllTestCases.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extend-report.xml");
//		htmlReporter.config().setDocumentTitle("My Store Project");
//		htmlReporter.config().setReportName("My Store Project Report");
//		htmlReporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("HostName", "MyHost");
		reports.setSystemInfo("ProjectName", "MyStoreProject");
		reports.setSystemInfo("Tester", "Devesh Sahare");
		reports.setSystemInfo("OS", "Win10");
		reports.setSystemInfo("Browser", "Chrome");
				
		
	}
	
	public void endReport() {
		
			reports.flush();
	
	}
}
