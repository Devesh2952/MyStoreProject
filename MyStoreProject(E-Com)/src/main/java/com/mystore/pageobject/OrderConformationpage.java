package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class OrderConformationpage extends Baseclass{
	
	public OrderConformationpage() {
		PageFactory.initElements( driver,this);
		}
	
	@FindBy(xpath = "//*[@class='alert alert-success']")
	WebElement confirmMsg ;
	
	public String confirmOrderMsg() {
		 String confirmmsg =confirmMsg.getText();
		 return confirmmsg;
		}
	
}
