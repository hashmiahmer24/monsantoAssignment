 package com.monsanto.TestScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.monsanto.util.DriverTestCase;

public class TestScriptFarmRise extends DriverTestCase {

	@Test
	public void onBoradingAction(){
	
		startExecutionOfNewTest("Start execution of Test Method '"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+"'");
		
		farmPageHelper.handleLangaugeSelection();
		farmPageHelper.clickOnProceedButton();
		farmPageHelper.clickOnAgreeAndConditionsButton();
		farmPageHelper.homeScreenAndTabs();
		farmPageHelper.navigateBackToHomeScreen();
		
	}
	
	@Test(dependsOnMethods="onBoradingAction")
	public void navigateWeatherAccessScreen(){
		
		startExecutionOfNewTest("Start execution of Test Method '"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+"'");
		
		farmPageHelper.clickOnAccessWeatherDetailsLink();
		farmPageHelper.verifyWeatherDetailsScreen();
		
	}
	
	@Test(dependsOnMethods="navigateWeatherAccessScreen")
	public void verifyAppTimeAgainstSystemTime(){
		
		startExecutionOfNewTest("Start execution of Test Method '"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+"'");
		
		farmPageHelper.verifyHours();
	}
	
	@Test(dependsOnMethods="navigateWeatherAccessScreen")
	public void navigateToGovernmentSchemesPage(){
		
		startExecutionOfNewTest("Start execution of Test Method '"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+"'");
		
		farmPageHelper.navigateToGovernmentSchemes();
		farmPageHelper.verifyGovernmentSchemesScreen();
		
	}
	
	@Test(dependsOnMethods="navigateToGovernmentSchemesPage")
	public void tapOnLoadMoreSchemesButton(){
		
		startExecutionOfNewTest("Start execution of Test Method '"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+"'");
		
		farmPageHelper.scrollTillVisibleElement();
	}
	
	@Test(dependsOnMethods="navigateToGovernmentSchemesPage")
	public void searchForKeyword(){
		
		startExecutionOfNewTest("Start execution of Test Method '"
				+ Thread.currentThread().getStackTrace()[1].getMethodName()+"'");
		
		farmPageHelper.searchForSpecificKeyword(propertyReader.readApplicationFile("keyword"));
		farmPageHelper.pressEnter();
		farmPageHelper.verifyTheResult(propertyReader.readApplicationFile("ExpectedSearchResult"));
	}
}
