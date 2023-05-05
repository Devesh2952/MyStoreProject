package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class Shippingpage extends Baseclass {
   public Shippingpage() {
	PageFactory.initElements( driver,this);
   }
   
   @FindBy(xpath = "//*[@id='cgv']")
   WebElement terms_Chechbox;
   
   @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
   WebElement proceedToCheckout;
   
   public void clickonTermCheckbox() {
	terms_Chechbox.click();
}
   public Paymentpage clickonCheckout() {
	   proceedToCheckout.click();
	   return new Paymentpage();
	
}
   
   
   
   
}
