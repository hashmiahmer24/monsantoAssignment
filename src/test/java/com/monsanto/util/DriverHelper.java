package com.monsanto.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import io.appium.java_client.android.AndroidDriver;


public abstract class DriverHelper {
	
	private AndroidDriver driver;
	public DriverHelper(AndroidDriver androidDriver) {
		driver = androidDriver;
		
	}
	
	public AndroidDriver getDriver(){
		return driver;
	}
	
	public By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		}else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
			
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		}
			
		  else if(locator.startsWith("class=")) {
				result=By.className(locator.replace("class=", ""));
			}
		  else if(locator.startsWith("name=")) {
				result=By.name(locator.replace("name=", ""));
			}
		  
		  else if(locator.startsWith("id=")) {
			  result=By.id(locator.replace("id=", ""));
		  }
		  else if(locator.startsWith("(")) {
			  result = By.xpath(locator);
		  }else {
			result = By.id(locator);
		}

		return result;
	}

	/*
	 * Selenium wrapper methods
	 * 
	*/
	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			getDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {

		}

		return result;
	}
	

	public Boolean isElementDisplayed(String locator) {

		Boolean result = false;
		try {
			getDriver().findElement(ByLocator(locator)).isDisplayed();
			result = true;
		} catch (Exception ex) {

		}
		return result;
	}
	

	public void WaitForElementPresent(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void WaitForElementVisible(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (getDriver().findElement(ByLocator(locator)).isDisplayed()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void clickOn(String locator)
	{		
		this.WaitForElementPresent(locator,1);
		Assert.assertTrue(isElementPresent(locator),"Element Locator :"+locator+" Not found");
		WebElement el = getDriver().findElement(ByLocator(locator));			
		el.click();
	}
	
	public void sendKeys(String locator, String userName){		
		this.WaitForElementPresent(locator, 1);		
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"+locator+" Not found");
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.clear();
		el.sendKeys(userName);
	}
	
	public String getScreenshot (String screenshotName) throws IOException{
	    DateFormat dateformate = new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
	    Date date = new Date();
	    String currentdate = dateformate.format(date);
	    String imageName =screenshotName+currentdate;
	    TakesScreenshot ts=(TakesScreenshot)getDriver();
	    File source=ts.getScreenshotAs(OutputType.FILE);
	    String location =System.getProperty("user.dir")+"\\attachedScreenshot\\"+imageName+".png";
	    File screenshotLocation =new File (location);
	    FileUtils.copyFile(source, screenshotLocation);
	    return location;

	}
	
	public void attachedToReport(String screenshotName) throws IOException{
		String screenshotPath =getScreenshot(screenshotName);
        System.out.println("Screenshot taken");
        String path = "<img src=\"file://" + screenshotPath + "\" alt=\"\" width='300' height='500'/>";
        System.out.println(screenshotPath+" and path - "+path);
        Reporter.log(path);
	}
	
	public String getText(String locator){
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator),"Element Locator :"+locator+" Not found");
		String text = getDriver().findElement(ByLocator(locator)).getText();	
		return text;
	}
	
	public String getCurrentTime(){
		DateFormat dateFormat = new SimpleDateFormat("h a");
		String formattedDate = dateFormat.format(new Date()).toString();
		return formattedDate;
	}
	
	public static void positiveComment(String str_positiveMessage){
		Reporter.log("<font color='green'>"+str_positiveMessage+"</font>");
	}
	
	public void negativeComment(String str_negativeMessage){
		Reporter.log("<font color='red'>"+str_negativeMessage+"</font>");
	}
	
	public void startExecutionOfNewTest(String str_negativeMessage){
		Reporter.log("<font color='blue'>"+str_negativeMessage+"</font>");
	}
	
	
}
