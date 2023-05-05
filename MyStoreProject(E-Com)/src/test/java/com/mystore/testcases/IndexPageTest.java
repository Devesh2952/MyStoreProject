/**
 * 
 */
package com.mystore.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobject.Indexpage;

/**
 * @author Hp
 *
 */

public class IndexPageTest extends Baseclass{
	
	@BeforeMethod(groups = {"Sanity","Regression","Smoke"})
	public void setup() {
		lunchbrowser();
	}
	
	@AfterMethod(groups = {"Sanity","Regression","Smoke"})
	public void tearDown() {
		driver.quit();
	}
	
	 Indexpage ip = new Indexpage();
	 
	 @Test(groups = "Smoke")
	public void verifyLogo() {
		
	 boolean result =  driver.findElement(By.xpath("//*[@class='logo img-responsive']")).isDisplayed();
	
                    Assert.assertTrue(result);
}
	@Test(groups = "Smoke")
	public void verifyTitle() {
		 Indexpage ip = new Indexpage();
		String ActTitle =ip.getmyStoreTitle();
		String ExpTitle ="My Store";
		Assert.assertEquals(ActTitle, ExpTitle);
		
	}
	
	
	
}
