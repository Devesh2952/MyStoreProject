package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.ProductDPClass;
import com.mystore.pageobject.AddToCardpage;
import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.OrderSummerypage;
import com.mystore.pageobject.Orderpage;
import com.mystore.pageobject.SearchResultpage;

public class OrderPageTest extends Baseclass{
	SearchResultpage SRpage;
	AddToCardpage  ATCpage ;
	Orderpage order;
	
	
	@BeforeMethod(groups = {"Sanity","Regression","Smoke"})
	public void setup() {
		lunchbrowser();
	}
	
	@AfterMethod(groups = {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Regression",dataProvider = "productdata",dataProviderClass = ProductDPClass.class)
	public void validateOrderPrice(String product ,String quantity,String size) throws InterruptedException {

		 Indexpage	 ip = new Indexpage();
			SRpage =  ip.SearchProduct(product);
			ATCpage =    SRpage.clickonProduct();
			ATCpage.enterQuantity(quantity);
		//	Thread.sleep(3000);
			ATCpage.selectSize(size);
			//Thread.sleep(5000);
			ATCpage.clickonAddToCart();
		//	Thread.sleep(3000);
		order=	ATCpage.clickonCheckOut();
	//	Thread.sleep(3000);
		
		
		Double unitprice =	 order.getUnitPrice();
		Double totalprice  = order.getTotalPrice();
		double ab =7.01;
		  Double	newTotal =(unitprice*2)+ab;
		  System.out.println(newTotal);
    Assert.assertEquals(totalprice, newTotal);
		
	
		
	}

}
