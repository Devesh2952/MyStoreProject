package com.mystore.actiondriver;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.mystore.base.Baseclass;

public class Action extends Baseclass {

	public static void implicitwait(WebDriver driver ,long timeout) {
	
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}


public static void pageloadtimeout(WebDriver driver ,long timeout) {

	driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}

public static void selectbyVisibleText(WebElement element , String value) {
	
	Select select = new Select( element);
	select.selectByVisibleText(value);
	
}

public static void JSclick(WebDriver driver ,WebElement  ele) {
	JavascriptExecutor js =(JavascriptExecutor) driver ;
	js.executeScript("arguments[0].click()", ele);
	
}

public static void fluentWait(WebElement element, int timeOut) {
    Wait<WebDriver> wait = null;
    try {
        wait = new FluentWait<WebDriver>((WebDriver) driver)
        		.withTimeout(Duration.ofSeconds(timeOut))
        	    .pollingEvery(Duration.ofSeconds(2))
        	    .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOf(element));
     
    }catch(Exception e) {
    }
}

public String screenShot(String filename) {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
	TakesScreenshot  takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();
	}
	return destination;

	
}
@Override
public String getCurrentTime() {
	String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date(0));
	return currentDate;
}



}