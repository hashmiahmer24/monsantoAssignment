package com.monsanto.PageHelper;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.monsanto.locators.LocatorReader;
import com.monsanto.util.DriverHelper;
import com.monsanto.util.ExecutionLog;
import com.monsanto.util.PropertyReader;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class FarmRisePageHelper extends DriverHelper {
	
private LocatorReader farmRiselocator;	
private PropertyReader propertyReader = new PropertyReader();

	public FarmRisePageHelper(AndroidDriver driver) {
		super(driver);	
		// Load locator page.
		farmRiselocator = new LocatorReader("FarmRise.xml");
	}

	public void handleLangaugeSelection(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("launcherScreens.languageSelection"))) {
				clickOn(farmRiselocator.getLocator("launcherScreens.languageSelection"));
				Reporter.log("Tap on 'English' langauge icon.");
							
			} else {
				
				Reporter.log("Laguage selection icon is not displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			Reporter.log("Unable to select language due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void clickOnProceedButton(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("launcherScreens.processButton"))) {
				clickOn(farmRiselocator.getLocator("launcherScreens.processButton"));
				Reporter.log("Tap on 'Proceed' button.");
							
			} else {
				
				Reporter.log("Proceed button is not displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			Reporter.log("Unable to tap on 'Process' button due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void clickOnAgreeAndConditionsButton(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("launcherScreens.termsAndConditionButton"))) {
				clickOn(farmRiselocator.getLocator("launcherScreens.termsAndConditionButton"));
				Reporter.log("Tap on 'Agreement & Conditions' button.");
							
			} else {
				
				Reporter.log("'Agreement & Conditions' button is not displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			Reporter.log("Unable to tap on 'Terms & Conditions' button due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void homeScreenAndTabs(){
		try {
			WaitForElementVisible(farmRiselocator.getLocator("homePage.homePageLogo"),30);
			if (isElementDisplayed(farmRiselocator.getLocator("homePage.homePageLogo"))) {
				clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
				Reporter.log("Home icon is displayed and tap on OK icon.");
				WaitForElementVisible(farmRiselocator.getLocator("homePage.mandiIcon"),30);
				if (isElementDisplayed(farmRiselocator.getLocator("homePage.mandiIcon"))) {
					clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
					Reporter.log("Mandi icon is displayed and tap on OK icon.");
					WaitForElementVisible(farmRiselocator.getLocator("homePage.agronomyIcon"),30);
					if (isElementDisplayed(farmRiselocator.getLocator("homePage.agronomyIcon"))) {
						clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
						Reporter.log("Agronomy icon is displayed and tap on OK icon.");
						WaitForElementVisible(farmRiselocator.getLocator("homePage.chatIcon"),30);
						if (isElementDisplayed(farmRiselocator.getLocator("homePage.chatIcon"))) {
							clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
							Reporter.log("Chat icon is displayed and tap on OK icon.");
							WaitForElementVisible(farmRiselocator.getLocator("homePage.hamburgerIcon"),30);
							if (isElementDisplayed(farmRiselocator.getLocator("homePage.hamburgerIcon"))) {
								clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
								Reporter.log("Hamburger icon is displayed and tap on OK icon.");
								
								
							} else {
								Reporter.log("Hamburger icon is not displayed");
								Assert.assertFalse(true);
							}
							
						} else {
							Reporter.log("Chat icon is not displayed");
							Assert.assertFalse(true);
						}
						
					} else {
						Reporter.log("Agronomy icon is not displayed");
						Assert.assertFalse(true);
					}
				} else {
					Reporter.log("Mandi icon is not displayed");
					Assert.assertFalse(true);
				}
				
			} else {
				Reporter.log("Home icon is not displayed");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			Reporter.log("Unable to handle home page gestures due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
		
	}
	
	public void navigateBackToHomeScreen(){
		try {
			WaitForElementVisible(farmRiselocator.getLocator("homePage.homePageLogo"),30);
			if (isElementPresent(farmRiselocator.getLocator("homePage.homePageLogo"))) {
				clickOn(farmRiselocator.getLocator("homePage.homePageLogo"));
				Reporter.log("Tap on Home icon..");
				
			}
		} catch (Exception e) {
			Reporter.log("Unable to navigate to home page due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void clickOnAccessWeatherDetailsLink(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("homePage.accessWeatherDetails"))) {
				
				clickOn(farmRiselocator.getLocator("homePage.accessWeatherDetails"));
				Reporter.log("Tap on Access Weather Details..");
				
			} else {
				
				Reporter.log("Access Weather Details link is not displayed..");
				Assert.assertFalse(true);
				
			}
		} catch (Exception e) {
			Reporter.log("Unable to tap on 'Access Weather Details' link due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void verifyWeatherDetailsScreen(){
		Assert.assertEquals(getText(farmRiselocator.getLocator("homePage.weatherScreenHeader")), propertyReader.readApplicationFile("weatherHeader"));
		Reporter.log("Successfully landed on 'Weather Details' screen..");
		
	}
	
	public void scrollHorizontally(String view_text){
		
		try {
			MobileElement carousal = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.climate.farmrise:id/hourlyWeatherForecastLayout\")).setAsHorizontalList().scrollIntoView("
					+ "new UiSelector().text(\""+view_text+"\"))"));
			Reporter.log("Successfully scroll till "+view_text+" text.");
		} catch (Exception e) {
			Reporter.log("Unable to perform horizontal scroll on temperature carousal due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void navigateToGovernmentSchemes(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("homePage.hamburgerIcon"))) {
				clickOn(farmRiselocator.getLocator("homePage.hamburgerIcon"));
				Reporter.log("Clicked on 'Hamburger' icon.");
				if (isElementDisplayed(farmRiselocator.getLocator("homePage.governmentSchemes"))) {
					clickOn(farmRiselocator.getLocator("homePage.governmentSchemes"));
					Reporter.log("'Government Schemes' link is displayed and tap on the same..");
				} else {
					Reporter.log("'Government Schemes' link is not displayed under menu drawer.");
					Assert.assertFalse(true);
				}
			} else {
				Reporter.log("'Hamburger' icon is not displayed..");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			Reporter.log("Unable to navigate to Government schemes page due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void verifyGovernmentSchemesScreen(){
		try {
			WaitForElementVisible(farmRiselocator.getLocator("homePage.governmentSchemesScreenHeading"), 30);
			if (isElementDisplayed(farmRiselocator.getLocator("homePage.governmentSchemesScreenHeading"))) {
				Reporter.log("Successfully landed on 'Government Schemes' page..");
				Assert.assertTrue(true);
				
			} else {
				Reporter.log("Unable to navigate to 'Government Schemes' page..");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			Reporter.log("Heading is not displayed as expected..");
			Assert.assertFalse(true);
		}
	}
	
	public void searchForSpecificKeyword(String str_keyWord){
		try {
			if (isElementPresent(farmRiselocator.getLocator("homePage.searchIcon"))) {
				clickOn(farmRiselocator.getLocator("homePage.searchIcon"));
				Reporter.log("Tap on search icon..");
				if (isElementPresent(farmRiselocator.getLocator("homePage.searchTextField"))) {
					sendKeys(farmRiselocator.getLocator("homePage.searchTextField"),str_keyWord);
					Reporter.log(str_keyWord+" keyword is entered into search text field..");
				} else {
					Reporter.log("Search text field is not displayed..");
					Assert.assertFalse(true);
				}
			} else {
				Reporter.log("Search icon is not displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			Reporter.log("Unable to performed search operation die to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void pressEnter(){
		try {
			getDriver().pressKeyCode(66);
			Reporter.log("Tap on enter from keyboard..");
		} catch (Exception e) {
			Reporter.log("Unable to tap on enter from keyboard");
			Assert.assertFalse(true);
		}
		
	}
	
	public void verifyTheResult(String expectedResult){
		try {
			if (!getText(farmRiselocator.getLocator("homePage.searchResultPage")).equalsIgnoreCase("We're sorry!")) {
				if (getText(farmRiselocator.getLocator("homePage.searchResultPageItem")).equalsIgnoreCase(expectedResult)) {
					Reporter.log("Search functionality is working fine...");
					Assert.assertTrue(true);
				} else {
					Reporter.log("Search functionality is not working properly...");
					Assert.assertFalse(true);
				}
			} else {
				Reporter.log("No item is displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			Reporter.log("Unable to perform search verification process due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
}
