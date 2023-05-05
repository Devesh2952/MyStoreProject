package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobject.AddToCardpage;
import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.SearchResultpage;

public class AddToCartPageTest extends Baseclass{
	SearchResultpage SRpage;
	AddToCardpage  ATCpage ;
	
	@BeforeMethod(groups = {"Sanity","Regression","Smoke"})
	public void setup() {
		lunchbrowser();
	}
	
	@AfterMethod(groups = {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = {"Sanity","Regression"})
	public void AddToCartTest() throws InterruptedException {
		 Indexpage	 ip = new Indexpage();
		SRpage =  ip.SearchProduct(prop.getProperty("product"));
		ATCpage =    SRpage.clickonProduct();
		ATCpage.enterQuantity(prop.getProperty("quantity"));
	//	Thread.sleep(3000);
		ATCpage.selectSize(prop.getProperty("size"));
		//Thread.sleep(5000);
		ATCpage.clickonAddToCart();
		Thread.sleep(3000);
		boolean result = ATCpage.validateAddtoCart();
		Thread.sleep(3000);
		Assert.assertTrue(result);
	
	}

}
