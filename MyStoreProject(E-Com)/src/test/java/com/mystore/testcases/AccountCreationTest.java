package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobject.AccountCreationpage;
import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.Loginpage;

public class AccountCreationTest extends Baseclass{
	Loginpage loginpage ;
	 AccountCreationpage  AccCreate;
	// Indexpage ip;
	 
	@BeforeMethod(groups = {"Sanity","Regression","Smoke"})
	public void setup() {
		lunchbrowser();
	}
	
	@AfterMethod(groups = {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	

	 
	 @Test(groups = "Sanity")
	 public void AccountCreationPageTest() throws InterruptedException {
		 Indexpage	 ip = new Indexpage();
		 loginpage=  ip.clickSingInBtn();
	    AccCreate=   	 loginpage.CreateNewAccount(prop.getProperty("email"));
	    Thread.sleep(5000);
	    boolean result = AccCreate.validateAcountCreationpage();
	    Assert.assertTrue(result);
		
	}

}
