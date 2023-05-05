package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class Paymentpage extends Baseclass {
	
	@FindBy(xpath = "//*[contains(text(),'Pay by bank wire')]")
	WebElement paybyBankWire;
	@FindBy(xpath ="//*[@class='cheque']" )
	WebElement paybyCheque;
	
	public Paymentpage() {
		PageFactory.initElements( driver,this);
	}
	
	public OrderSummerypage clickonPaybyBank() {
		paybyBankWire.click();
		return new OrderSummerypage();
		}
	public OrderSummerypage clickonPaybyCheque() {
		paybyCheque.click();
		return new OrderSummerypage();
		
	}


}
