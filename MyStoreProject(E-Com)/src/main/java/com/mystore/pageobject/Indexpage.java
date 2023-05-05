package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class Indexpage extends Baseclass {

           @FindBy(xpath="//*[@class='login']")
			WebElement SingInBtn ;
           
           @FindBy(xpath="//*[@class='login']")
			WebElement CardBtn ;
	
	@FindBy(xpath = "//*[@id='search_query_top']")
	WebElement Searchbox ;
	
	@FindBy(xpath = "//*[@name='submit_search']")
	WebElement Searchbtn ;
	
	@FindBy(xpath = "//*[@class='logo img-responsive'] ")
	WebElement mySearchlogo ;
	
	public  Indexpage() {
		PageFactory.initElements( driver,this);
	}
	
	public Loginpage  clickSingInBtn() {
		SingInBtn.click();
		return new  Loginpage();
		}
	
	public SearchResultpage SearchProduct(String productname) {
		Searchbox.sendKeys(productname);
		Searchbtn.click();
		return new SearchResultpage() ;
	}
	
public boolean validateLogo() {
	return 	mySearchlogo.isDisplayed();
		
	}
	
	public String getmyStoreTitle() {
		String title = driver.getTitle();
	   return title;	
	}
	
public Orderpage clickToCart() {
	CardBtn.click();
	return new Orderpage();
	
}
	
	
	
	
}
