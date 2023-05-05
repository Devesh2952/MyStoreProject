package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.SearchResultpage;

public class SearchResultPageTest extends Baseclass{
	SearchResultpage SRpage;
	
	@BeforeMethod(groups = {"Sanity","Regression","Smoke"})
	public void setup() {
		lunchbrowser();
	}
	
	@AfterMethod(groups = {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Smoke")
	public void productAvablityTest() throws InterruptedException {
		 Indexpage	 ip = new Indexpage();
		SRpage =  ip.SearchProduct(prop.getProperty("product"));
		Thread.sleep(5000);
		boolean result =SRpage.isProductAvailable();
		Assert.assertTrue(result);
		
	}

}
