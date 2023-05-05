package com.mystore.pageobject;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class Addresspage extends Baseclass{

	@FindBy (xpath ="//*[@id='firstname']" )
	WebElement  firstname;
	@FindBy (xpath = "//*[@id='lastname']")
	WebElement  lastname ;
	@FindBy (xpath ="//*[@id='address1'] " )
	WebElement  address;
	@FindBy (xpath = "//*[@id='city']")
	WebElement  city;
	@FindBy (xpath ="//*[@id='id_state']" )
	WebElement state ;
	
	@FindBy (xpath ="//*[@id='postcode']" )
	WebElement postalcode;
	@FindBy (xpath ="//*[@id='id_country']" )
	WebElement country ;
	@FindBy (xpath ="//*[@id='phone_mobile']" )
	WebElement mobileNo ;
	@FindBy(xpath = "//*[@id='alias']")
	WebElement addressAlias;
	
	@FindBy(xpath = "//*[@id=\"submitAddress\"]")
	WebElement saveBtn;
	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public Addresspage() {
		PageFactory.initElements( driver,this);
	}
	
	public void enterFullName(String firstName, String lastName ) {
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
	}
	
	public void enterAddress(String Address) {
		address.sendKeys(Address);
		}
	
	public void enterCity(String Cityname) {
		city.sendKeys(Cityname);
		}
	
	public void enterState( String Statename) {
		Action.selectbyVisibleText(state, Statename);
	}
	
	public void enterPostalCode(String PostalCodeNum) {
		postalcode.sendKeys(PostalCodeNum);
		}
	
	public void enterCountary(String Countaryname) {
		Action.selectbyVisibleText(country, Countaryname);
			}
	
	public void enterMobileNum(String Mob_No) {
		mobileNo.sendKeys(Mob_No);
		}
	
	public void CreateAddressAliases(String Add_aliass) {
		addressAlias.sendKeys(Add_aliass);
		}
	
	private void clickOnSave() {
		saveBtn.click();
	}
	
	public Shippingpage clickonCheckOut () {
		proceedToCheckOut.click();
		return new Shippingpage();
		
	}
}
