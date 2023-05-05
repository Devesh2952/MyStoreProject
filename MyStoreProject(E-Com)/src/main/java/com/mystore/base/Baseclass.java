package com.mystore.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Baseclass {
	
	public static WebDriver driver;
	public static Properties prop ;

	@BeforeTest(groups = {"Sanity","Regression","Smoke"})
	public void loadconfig() {
		
		try {
			prop=new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			prop.load(fs);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
		e.printStackTrace();
		
		}
		}
	
@BeforeTest(groups = {"Sanity","Regression","Smoke"})
	public void lunchbrowser() {
		WebDriverManager.chromedriver().setup();
		String browser = prop.getProperty("browser");
		
		if(browser.contains("Chromebrowser")) {
			driver = new ChromeDriver();
			
			}
		
		else	if(browser.contains("FireFoxbrowser")) {
			driver = new FirefoxDriver();
			
			}
		
		driver.manage().window().maximize();
          Action.implicitwait(driver,25);
          Action.pageloadtimeout(driver,40);
          driver.get(prop.getProperty("url"));
		
	}

public String getCurrentTime() {
	
	return  getCurrentTime();
}

public static WebDriver getDriver() {
	driver = new ChromeDriver();
	return driver;
}






//@AfterSuite(groups = {"Sanity","Regression","Smoke"})
//public void closebrowser() {
//	driver.quit();  
//}

	

}
