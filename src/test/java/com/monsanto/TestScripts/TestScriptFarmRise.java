package com.monsanto.TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.monsanto.util.DriverTestCase;
import com.monsanto.util.ExecutionLog;

public class TestScriptFarmRise extends DriverTestCase {

	@Test
	public void onBoradingAction(){
	
		Reporter.log(this.getClass().getName()
				+ " and Test method "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+" is going to execute...");
		
		farmPageHelper.handleLangaugeSelection();
		farmPageHelper.clickOnProceedButton();
		farmPageHelper.clickOnAgreeAndConditionsButton();
		farmPageHelper.homeScreenAndTabs();
		farmPageHelper.navigateBackToHomeScreen();
		
	}
	
	@Test(dependsOnMethods="onBoradingAction")
	public void navigateWeatherAccessScreen(){
		
		Reporter.log(this.getClass().getName()
				+ " and Test method "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+" is going to execute...");
		
		farmPageHelper.clickOnAccessWeatherDetailsLink();
		farmPageHelper.verifyWeatherDetailsScreen();
		farmPageHelper.scrollHorizontally(propertyReader.readApplicationFile("visibleText"));
	}
	
	@Test(dependsOnMethods="navigateWeatherAccessScreen")
	public void navigateToGovernmentSchemesPage(){
		
		Reporter.log(this.getClass().getName()
				+ " and Test method "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+" is going to execute...");
		
		farmPageHelper.navigateToGovernmentSchemes();
		farmPageHelper.verifyGovernmentSchemesScreen();
		
	}
	
	@Test(dependsOnMethods="navigateToGovernmentSchemesPage")
	public void searchForKeyword(){
		
		Reporter.log(this.getClass().getName()
				+ " and Test method "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+" is going to execute...");
		
		farmPageHelper.searchForSpecificKeyword(propertyReader.readApplicationFile("keyword"));
		farmPageHelper.pressEnter();
		farmPageHelper.verifyTheResult(propertyReader.readApplicationFile("ExpectedSearchResult"));
	}
}
