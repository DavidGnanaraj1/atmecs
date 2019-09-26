package com.atmecs.automation.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.automations.constants.FilePath;
import com.atmecs.automations.helperpage.ValidateContextMenu;
import com.atmecs.automations.pageactions.PageActions;
import com.atmecs.automations.pageactions.PageActionsScrollDown;
import com.atmecs.automations.reports.ExtentReport;
import com.atmecs.automations.reports.LogReport;
import com.atmecs.automations.testbase.BrowserInvoke;
import com.atmecs.automations.utils.PropertiesFileReader;
import com.atmecs.automations.utils.TestDataProvider;
import com.atmecs.automations.validatetest.ValidateFooter;
import com.relevantcodes.extentreports.LogStatus;


public class VerifyFootersAndContexts extends BrowserInvoke {
	LogReport log = new LogReport();
	
	@Test  
	public void verifyFooterContext() throws IOException {
	
		PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);
	    
		
		//verifying footers in services
		PageActions.click(driver,PropertiesFileReader.getData("loc.homepage.services"));
		PageActionsScrollDown.scrollDownToBottom(driver);
		ValidateFooter.validateFooterdata(driver);
		log.info("Services Link footers verified");
		
		PageActionsScrollDown.productPageScrollUp( driver) ;
		PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);
		PageActions.click(driver,PropertiesFileReader.getData("loc.homepage.home"));
	
		ValidateContextMenu valid = new ValidateContextMenu();
		valid.validateContextMenu(driver);
		
		
	}

}