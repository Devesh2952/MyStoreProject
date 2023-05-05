package com.mystore.pageobject;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class AddToCardpage extends Baseclass {
	
	public AddToCardpage() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//*[@id='quantity_wanted']")
			WebElement quantity ;
	@FindBy(xpath = "//*[@id='group_1']")
      WebElement size ;
	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement addtocartbtn ;
	
	@FindBy(xpath = "//*[@class='icon-check']")
	WebElement sucessaddtocart ;
	
	@FindBy(xpath ="//*[contains(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckOut ;
	
	public void enterQuantity(String num) {
		quantity.clear();
		quantity.sendKeys(num);
	}
	public void selectSize(String size1) {
		com.mystore.actiondriver.Action.selectbyVisibleText(size, size1);
	}
	
	public void clickonAddToCart() {
		addtocartbtn.click();
		com.mystore.actiondriver.Action.implicitwait(driver, 30);
	}
	
	public boolean validateAddtoCart() {
		 return  sucessaddtocart.isDisplayed();
		}
	
	public Orderpage clickonCheckOut() {
		com.mystore.actiondriver.Action.fluentWait(proceedtoCheckOut, 30);
		com.mystore.actiondriver.Action.JSclick(driver, proceedtoCheckOut);
		return new Orderpage();
		
	}
		
		
	}
	

