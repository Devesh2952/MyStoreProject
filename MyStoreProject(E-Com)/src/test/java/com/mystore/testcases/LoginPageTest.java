package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.LoginDPClass;
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.Loginpage;



public class LoginPageTest extends Baseclass {


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
	
	
	@Test(dataProvider = "logindata",dataProviderClass = LoginDPClass.class, groups = {"Smoke","Sanity"})
	 public void LoginTest(String username,String password)  {
	
		Indexpage ip = new Indexpage();
		loginpage=  ip.clickSingInBtn();
           homepage =loginpage.login(username,password);
           String actualUrl = homepage.getUrl();
           String expectedUrl ="http://automationpractice.pl/index.php?controller=my-account";
           Assert.assertEquals(actualUrl, expectedUrl);
           
	}
	 
}
