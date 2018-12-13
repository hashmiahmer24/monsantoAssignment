package com.monsanto.PageHelper;


import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import com.monsanto.locators.LocatorReader;
import com.monsanto.util.DriverHelper;
import com.monsanto.util.PropertyReader;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class FarmRisePageHelper extends DriverHelper {
	
private LocatorReader farmRiselocator;	
private PropertyReader propertyReader = new PropertyReader();
public static ArrayList<String> dynamic_timeFromApp = new ArrayList<String>();
public static ArrayList<String> expected_timeAsSytemTime = new ArrayList<String>();

	public FarmRisePageHelper(AndroidDriver driver) {
		super(driver);	
		// Load locator page.
		farmRiselocator = new LocatorReader("FarmRise.xml");
	}

	public void handleLangaugeSelection(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("launcherScreens.languageSelection"))) {
				List<MobileElement> list_language = getDriver().findElements(ByLocator(farmRiselocator.getLocator("launcherScreens.languageSelection")));
				for (MobileElement ele_language : list_language) {
					if (ele_language.getText().trim().equalsIgnoreCase(propertyReader.readApplicationFile("Language"))) {
						ele_language.click();
						positiveComment("Tap on 'English' langauge icon.");
						break;
					}
				}
				
			} else {
				
				negativeComment("Laguage selection icon is not displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			negativeComment("Unable to select language due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void clickOnProceedButton(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("launcherScreens.processButton"))) {
				clickOn(farmRiselocator.getLocator("launcherScreens.processButton"));
				positiveComment("Tap on 'Proceed' button.");
							
			} else {
				
				negativeComment("Proceed button is not displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			negativeComment("Unable to tap on 'Process' button due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void clickOnAgreeAndConditionsButton(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("launcherScreens.termsAndConditionButton"))) {
				clickOn(farmRiselocator.getLocator("launcherScreens.termsAndConditionButton"));
				positiveComment("Tap on 'Agreement & Conditions' button.");
							
			} else {
				
				negativeComment("'Agreement & Conditions' button is not displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			negativeComment("Unable to tap on 'Terms & Conditions' button due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void homeScreenAndTabs(){
		try {
			WaitForElementVisible(farmRiselocator.getLocator("homePage.homePageLogo"),30);
			if (isElementDisplayed(farmRiselocator.getLocator("homePage.homePageLogo"))) {
				clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
				positiveComment("Home icon is displayed and tap on OK icon.");
				WaitForElementVisible(farmRiselocator.getLocator("homePage.mandiIcon"),30);
				if (isElementDisplayed(farmRiselocator.getLocator("homePage.mandiIcon"))) {
					clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
					positiveComment("Mandi icon is displayed and tap on OK icon.");
					WaitForElementVisible(farmRiselocator.getLocator("homePage.agronomyIcon"),30);
					if (isElementDisplayed(farmRiselocator.getLocator("homePage.agronomyIcon"))) {
						clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
						positiveComment("Agronomy icon is displayed and tap on OK icon.");
						WaitForElementVisible(farmRiselocator.getLocator("homePage.chatIcon"),30);
						if (isElementDisplayed(farmRiselocator.getLocator("homePage.chatIcon"))) {
							clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
							positiveComment("Chat icon is displayed and tap on OK icon.");
							WaitForElementVisible(farmRiselocator.getLocator("homePage.hamburgerIcon"),30);
							if (isElementDisplayed(farmRiselocator.getLocator("homePage.hamburgerIcon"))) {
								clickOn(farmRiselocator.getLocator("homePage.okayIcon"));
								positiveComment("Hamburger icon is displayed and tap on OK icon.");
								
								
							} else {
								negativeComment("Hamburger icon is not displayed");
								Assert.assertFalse(true);
							}
							
						} else {
							negativeComment("Chat icon is not displayed");
							Assert.assertFalse(true);
						}
						
					} else {
						negativeComment("Agronomy icon is not displayed");
						Assert.assertFalse(true);
					}
				} else {
					negativeComment("Mandi icon is not displayed");
					Assert.assertFalse(true);
				}
				
			} else {
				negativeComment("Home icon is not displayed");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			negativeComment("Unable to handle home page gestures due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
		
	}
	
	public void navigateBackToHomeScreen(){
		try {
			WaitForElementVisible(farmRiselocator.getLocator("homePage.homePageLogo"),30);
			if (isElementPresent(farmRiselocator.getLocator("homePage.homePageLogo"))) {
				clickOn(farmRiselocator.getLocator("homePage.homePageLogo"));
				positiveComment("Tap on Home icon..");
				
			}
		} catch (Exception e) {
			negativeComment("Unable to navigate to home page due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void clickOnAccessWeatherDetailsLink(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("homePage.accessWeatherDetails"))) {
				
				clickOn(farmRiselocator.getLocator("homePage.accessWeatherDetails"));
				positiveComment("Tap on Access Weather Details..");
				
			} else {
				
				negativeComment("Access Weather Details link is not displayed..");
				Assert.assertFalse(true);
				
			}
		} catch (Exception e) {
			negativeComment("Unable to tap on 'Access Weather Details' link due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void verifyWeatherDetailsScreen(){
		try {
			Assert.assertEquals(getText(farmRiselocator.getLocator("homePage.weatherScreenHeader")), propertyReader.readApplicationFile("weatherHeader"),"Unable to navigate to 'Weather Details'");
			positiveComment("Successfully landed on 'Weather Details' screen..");
		} catch (Exception e) {
			
			negativeComment("Unable to navigate to 'Weather Details' page due to error: "+e.getMessage());
		}
		
	}
	
	public void verifyHours(){
		try {
		
		String 	str_startTime= "";
		int startTime=0;
		int endTime=0;
		String str_endTime = "";
		
		List<MobileElement> list_hrsText = getDriver().findElements(ByLocator(farmRiselocator.getLocator("homePage.hoursText")));
		 
		String str_AppStartTime = list_hrsText.get(1).getText().trim();
		positiveComment("App time: "+str_AppStartTime);
		if(!str_AppStartTime.trim().equalsIgnoreCase("12 PM") && !str_AppStartTime.trim().equalsIgnoreCase("1 PM") && !str_AppStartTime.trim().equalsIgnoreCase("1 AM")){
			startTime = Integer.parseInt(getCurrentTime().split("\\s+")[0])+1;
			str_startTime = Integer.toString(startTime)+" "+getCurrentTime().split("\\s+")[1];
			endTime = Integer.parseInt(getCurrentTime().split("\\s+")[0])-1;
			str_endTime = Integer.toString(endTime)+" "+getCurrentTime().split("\\s+")[1];
		}else if(str_AppStartTime.trim().equalsIgnoreCase("1 PM")){
			startTime = Integer.parseInt(getCurrentTime().split("\\s+")[0])+1;
			str_startTime = Integer.toString(startTime)+" "+getCurrentTime().split("\\s+")[1];
			endTime = 12;
			str_endTime = Integer.toString(endTime)+" "+getCurrentTime().split("\\s+")[1];
		}else if(str_AppStartTime.trim().equalsIgnoreCase("1 AM")){
			startTime = Integer.parseInt(getCurrentTime().split("\\s+")[0])+1;
			str_startTime = Integer.toString(startTime)+" "+getCurrentTime().split("\\s+")[1];
			endTime = 12;
			str_endTime = Integer.toString(endTime)+" "+"AM";
		}else if(str_AppStartTime.equalsIgnoreCase("12 PM")){
			startTime = 1;
			str_startTime = Integer.toString(startTime)+" "+getCurrentTime().split("\\s+")[1];
			endTime = Integer.parseInt(getCurrentTime().split("\\s+")[0])-1;
			str_endTime = Integer.toString(endTime)+" "+"AM";
		}else if(str_AppStartTime.equalsIgnoreCase("12 AM")){
			startTime = 1;
			str_startTime = Integer.toString(startTime)+" "+getCurrentTime().split("\\s+")[1];
			endTime = Integer.parseInt(getCurrentTime().split("\\s+")[0])-1;
			str_endTime = Integer.toString(endTime)+" "+"PM";
		}
		positiveComment("End time to scroll: "+str_endTime);
		scrollHorizontally(str_endTime);
		List<MobileElement> list_hrsText2 = getDriver().findElements(ByLocator(farmRiselocator.getLocator("homePage.hoursText")));
		String str_AppEndTime = list_hrsText2.get(4).getText();
			
			if(str_AppStartTime.equalsIgnoreCase(str_startTime) && str_AppEndTime.equalsIgnoreCase(str_endTime)){
				positiveComment("App time showing as expected. App Start & End Time is : "+str_AppStartTime+" and "+str_AppEndTime+" and system start & end time is : "+str_startTime+" and "+str_endTime);
				Assert.assertTrue(true);
			//Assert.assertEquals(dynamic_timeFromApp, expected_timeAsSytemTime,"App time is not matched with system time..");
			}else{
				negativeComment("App time is not matched with system time.. Expected time is: "+str_startTime+"  BUT found: "+str_AppStartTime);
				scrollHorizontally(str_endTime);
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			
			negativeComment("App time is not matched with system time.. "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void scrollHorizontally(String view_text){
		
		try {
			MobileElement carousel = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.climate.farmrise:id/hourlyWeatherForecastLayout\")).setAsHorizontalList().scrollIntoView("
					+ "new UiSelector().text(\""+view_text+"\"))"));
			positiveComment("Successfully scroll till "+view_text+" text.");
		} catch (Exception e) {
			negativeComment("Unable to perform horizontal scroll on temperature carousal due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void navigateToGovernmentSchemes(){
		try {
			if (isElementPresent(farmRiselocator.getLocator("homePage.hamburgerIcon"))) {
				clickOn(farmRiselocator.getLocator("homePage.hamburgerIcon"));
				positiveComment("Clicked on 'Hamburger' icon.");
				if (isElementDisplayed(farmRiselocator.getLocator("homePage.governmentSchemes"))) {
					clickOn(farmRiselocator.getLocator("homePage.governmentSchemes"));
					positiveComment("'Government Schemes' link is displayed and tap on the same..");
				} else {
					negativeComment("'Government Schemes' link is not displayed under menu drawer.");
					Assert.assertFalse(true);
				}
			} else {
				negativeComment("'Hamburger' icon is not displayed..");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			negativeComment("Unable to navigate to Government schemes page due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void verifyGovernmentSchemesScreen(){
		try {
			WaitForElementVisible(farmRiselocator.getLocator("homePage.governmentSchemesScreenHeading"), 30);
			if (isElementDisplayed(farmRiselocator.getLocator("homePage.governmentSchemesScreenHeading"))) {
				positiveComment("Successfully landed on 'Government Schemes' page..");
				Assert.assertTrue(true);
				
			} else {
				negativeComment("Unable to navigate to 'Government Schemes' page..");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			negativeComment("Heading is not displayed as expected..");
			Assert.assertFalse(true);
		}
	}
	
	public void scrollTillVisibleElement(){
		try {
			if (isElementDisplayed(farmRiselocator.getLocator("homePage.governmentSchemesScreenHeading"))) {
				MobileElement element = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().resourceId(\"com.climate.farmrise:id/action_bar_root\")).setMaxSearchSwipes(3).scrollIntoView("
						+ "new UiSelector().text(\"Load More schemes\"))"));
				
				clickOn(farmRiselocator.getLocator("homePage.loadMoreSchemesButton"));
				positiveComment("Tap on 'Load more Schemes' button.");
				Assert.assertTrue(true);
			} else {
				negativeComment("Unable to navigate 'Government Schemes' page.");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			if(e.getMessage().contains("An element could not be located")){
			negativeComment("'Load More Schemes' button is not present on page..");
			Assert.assertFalse(true);
			}
		}
	}
	
	public void searchForSpecificKeyword(String str_keyWord){
		try {
			if (isElementPresent(farmRiselocator.getLocator("homePage.searchIcon"))) {
				clickOn(farmRiselocator.getLocator("homePage.searchIcon"));
				positiveComment("Tap on search icon..");
				if (isElementPresent(farmRiselocator.getLocator("homePage.searchTextField"))) {
					sendKeys(farmRiselocator.getLocator("homePage.searchTextField"),str_keyWord);
					positiveComment(str_keyWord+" keyword is entered into search text field..");
				} else {
					negativeComment("Search text field is not displayed..");
					Assert.assertFalse(true);
				}
			} else {
				negativeComment("Search icon is not displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			negativeComment("Unable to performed search operation due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
	
	public void pressEnter(){
		try {
			((AndroidDriver)getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
			positiveComment("Tap on enter from keyboard..");
		
		} catch (Exception e) {
			negativeComment("Unable to tap on enter from keyboard "+e.getMessage());
			Assert.assertFalse(true);
		}
		
	}
	
	public void verifyTheResult(String expectedResult){
		try {
			if (!getText(farmRiselocator.getLocator("homePage.searchResultPage")).equalsIgnoreCase("We're sorry!")) {
				if (getText(farmRiselocator.getLocator("homePage.searchResultPageItem")).equalsIgnoreCase(expectedResult)) {
					positiveComment("Search functionality is working fine...");
					Assert.assertTrue(true);
				} else {
					negativeComment("Search functionality is not working properly...");
					Assert.assertFalse(true);
				}
			} else {
				negativeComment("No item is displayed...");
				Assert.assertFalse(true);
			}
		} catch (Exception e) {
			negativeComment("Unable to perform search verification process due to error: "+e.getMessage());
			Assert.assertFalse(true);
		}
	}
}
