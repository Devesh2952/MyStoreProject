package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.LoginDPClass;
import com.mystore.pageobject.AddToCardpage;
import com.mystore.pageobject.Addresspage;
import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.Loginpage;
import com.mystore.pageobject.OrderConformationpage;
import com.mystore.pageobject.OrderSummerypage;
import com.mystore.pageobject.Orderpage;
import com.mystore.pageobject.Paymentpage;
import com.mystore.pageobject.SearchResultpage;
import com.mystore.pageobject.Shippingpage;

public class EndToEndTest extends Baseclass {
	SearchResultpage SRpage;
	AddToCardpage  ATCpage ;
	Orderpage order;
	Loginpage loginpage;
	Addresspage addresspage;
	Shippingpage shippingpage;
	Paymentpage paymentpage;
	OrderSummerypage orderSummerypage;
	OrderConformationpage orderConformationpage;
	
	@BeforeMethod(groups = {"Sanity","Regression","Smoke"})
	public void setup() {
		lunchbrowser();
	}
	
	@AfterMethod(groups = {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "logindata",dataProviderClass = LoginDPClass.class,groups = "Regression")
	public void validatingEndToEndFuctionality(String user, String pass) {
		 Indexpage ip = new Indexpage();
		 SRpage =  ip.SearchProduct(prop.getProperty("product"));		 
			ATCpage =    SRpage.clickonProduct();
			ATCpage.enterQuantity(prop.getProperty("quantity"));
		//	Thread.sleep(3000);
			ATCpage.selectSize(prop.getProperty("size"));
			//Thread.sleep(5000);
			ATCpage.clickonAddToCart();
			order=	ATCpage.clickonCheckOut();
			loginpage= order.clickonCheckOut();
		//	addresspage= loginpage.login1(prop.getProperty("username"),prop.getProperty("password"));
			addresspage= loginpage.login1(user,pass);
			 shippingpage=  addresspage.clickonCheckOut();
			 shippingpage.clickonTermCheckbox();
			 paymentpage=  shippingpage.clickonCheckout();
			 orderSummerypage=  paymentpage.clickonPaybyBank();
			orderConformationpage=  orderSummerypage.clickToConfirm();
			  String expectedMsg= orderConformationpage.confirmOrderMsg();
			  String actualMsg = prop.getProperty("Msg");
			  Assert.assertEquals(actualMsg, expectedMsg);
			
		
	}

}
