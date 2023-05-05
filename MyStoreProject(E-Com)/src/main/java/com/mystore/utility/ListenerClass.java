package com.mystore.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class ListenerClass extends ExtentManeger  implements ITestListener {

	Action action = new Action();
	public void onStart(ITestContext context) {
	    try {
			startReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	public void onFinish(ITestContext context) {
	    endReport();
	  }
	public  void onTestStart(ITestResult result) {
                
		test =reports.createTest(result.getName());
		}
	public void onTestSuccess(ITestResult result) {
	if(result.getStatus() == ITestResult.SUCCESS) {

		test.log(Status.PASS, "Pass Test case is: " + result.getName());
		
	}
	  }
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String imgPath = action.screenShot(result.getName());

			test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			
		}
	  }
	 public void onTestSkipped(ITestResult result) {
		   test.log(Status.SKIP,MarkupHelper.createLabel(result.getName() +" - Test Case Skiped .", ExtentColor.YELLOW));
		   
		  }
	 
//public void onTestFinish(ITestResult result) {
//		    endReport();
//		  }
//	
}


