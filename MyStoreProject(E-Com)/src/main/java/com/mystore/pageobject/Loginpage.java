package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class Loginpage extends Baseclass{
	
@FindBy (xpath = "//*[@id='email']")
WebElement Emailbox  ;
	
@FindBy(xpath = "//*[@id='passwd']")
WebElement Passwordbox ;

@FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
WebElement Submitbtn ;

@FindBy(xpath ="//*[@id='email_create']")
WebElement CreateAccountemailbox ;

@FindBy(xpath ="//*[@id=\"SubmitCreate\"]/span")
WebElement CreateAccountSubmitbtn ;


public Homepage login(String username , String password ) {
	Emailbox.sendKeys(username);
	Passwordbox.sendKeys(password);
	Submitbtn.click();
	return new Homepage();
}

public Addresspage login1(String username , String password ) {
	Emailbox.sendKeys(username);
	Passwordbox.sendKeys(password);
	Submitbtn.click();
	return new Addresspage();
}

public AccountCreationpage CreateNewAccount(String email) {
	CreateAccountemailbox.sendKeys(email);
	CreateAccountSubmitbtn.click();
	return new AccountCreationpage();
} 

public Loginpage() {
	PageFactory.initElements(driver,this);
}

}
