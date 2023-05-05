package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.Loginpage;

public class HomePageTest extends Baseclass {
	
	Indexpage indexpage ;
	Loginpage loginpage ;
	 Homepage homepage ;
	 
	@BeforeMethod(groups = {"Sanity","Regression","Smoke"})
	public void setup() {
		lunchbrowser();
	}
	
	@AfterMethod(groups = {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(groups = "Smoke")
	public void validateOrderHistery() {
		indexpage = new Indexpage();
		loginpage= indexpage.clickSingInBtn();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homepage.validateorderHistory();
		Assert.assertTrue(result);
		
	}
}
