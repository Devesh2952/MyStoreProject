
package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.base.Baseclass;

public class SearchResultpage extends Baseclass{

	@FindBy(xpath ="//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    WebElement  SearchedProduct ;
	
	public SearchResultpage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean isProductAvailable() {
		 return SearchedProduct.isDisplayed();
	}
	
public AddToCardpage clickonProduct() {
	SearchedProduct.click();
	return new AddToCardpage();
}
	
	
}
