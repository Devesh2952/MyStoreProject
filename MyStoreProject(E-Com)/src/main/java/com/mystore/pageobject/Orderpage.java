package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class Orderpage extends Baseclass {

	@FindBy(xpath = "//*[@id=\"product_price_6_32_0\"]/li")
	WebElement UnitPrice;

	@FindBy(xpath = "//*[@id='total_shipping']")
	WebElement ShippingPrice;

	@FindBy(xpath = "//*[@id='total_price_container']")
	WebElement TotalPrice;

	@FindBy(xpath = "//*[text()='Proceed to checkout']")
	WebElement ProceedToChechOut;

	public Orderpage() {
		PageFactory.initElements(driver, this);
	}

	public double getUnitPrice() {
		String UnitPrice1 = UnitPrice.getText();
		String unit = UnitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitPrice = Double.parseDouble(unit);
		return finalunitPrice/100;
	}

//	public void getUnitPrice() {
//		String UnitPrice1 = UnitPrice.getText();
//		String unit = UnitPrice1.replaceAll("[^a-zA-Z0-9]", "");
//		System.out.println(unit);
//	}

	public double getShippingPrice() {
		String ShippingPrice1 = ShippingPrice.getText();
		String shipping = ShippingPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalShippingPrice = Double.parseDouble(shipping);
		return finalShippingPrice/100;
	}

	public double getTotalPrice() {
		String TotalPrice1 = TotalPrice.getText();
		String total = TotalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice/100;
	}

//	public void getTotalPrice() {
//		String TotalPrice1 =TotalPrice.getText();
//		String total = TotalPrice1.replaceAll("[^a-zA-Z0-9]", "");
//		
//	     System.out.println(total);
//	}

	public Loginpage clickonCheckOut() {
		ProceedToChechOut.click();
		return new Loginpage();
	}

}
