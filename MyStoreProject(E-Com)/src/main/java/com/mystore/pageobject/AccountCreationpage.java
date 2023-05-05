package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class AccountCreationpage extends Baseclass {
	
	@FindBy(xpath = "//*[text()='Create an account']")
	WebElement formTitle ;
	
	public AccountCreationpage() {
	PageFactory.initElements(driver, this);
	}

	public boolean validateAcountCreationpage() {
		return  formTitle.isDisplayed();
	}
}
