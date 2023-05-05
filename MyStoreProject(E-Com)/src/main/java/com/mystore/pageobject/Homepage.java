package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class Homepage extends Baseclass{
	
	@FindBy(xpath = "//*[text()='Order history and details']")
	WebElement orderHistory ;
	
	public Homepage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateorderHistory() {
		return orderHistory.isDisplayed();
	}
	
	
	public String getUrl() {
		return  driver.getCurrentUrl();
	}

}
