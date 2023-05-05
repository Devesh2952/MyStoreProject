package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class OrderSummerypage extends Baseclass {
	 public OrderSummerypage() {
		 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy(xpath = "//*[text()='I confirm my order']")
	 WebElement  confirmMyOrderBtn;
	 
	 public OrderConformationpage clickToConfirm() {
		 confirmMyOrderBtn.click();
		 return new OrderConformationpage();
		
	}
	 

	 

}
