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
import com.atmecs.automations.utils.ExcelFileReader;
import com.atmecs.automations.utils.PropertiesFileReader;
import com.atmecs.automations.utils.TestDataProvider;
import com.atmecs.automations.validatetest.ValidateFooter;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class VerifyFootersAndContexts extends BrowserInvoke {
	LogReport log = new LogReport();

	@Test
	public void verifyFooterContext() throws IOException {

		PropertiesFileReader prop = new PropertiesFileReader();
		PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);

String footers[]= {"loc.homepage.services","loc.homepage.partners","loc.homepage.media","loc.homepage.insights","loc.homepage.home"};
		
	for(int k=0;k<footers.length;k++) {
		int i;
		int sheet =0;
		int colnum = 0;
		String array[]=new String[9];
		PageActions.click(driver,PropertiesFileReader.getData(footers[k] ));
		PageActionsScrollDown.scrollDownToBottom(driver);
		for(i=0;i<array.length;i++) {
			ExcelFileReader readexcel = new ExcelFileReader(FilePath.TESTDATA_FILE);
			
			int j=i+2;
		array[i]  = ExcelFileReader.getData(sheet,j,colnum);
		

	
		String xpath = (PropertiesFileReader.getData("loc.footers.xpath")).replace("xxxx", array[i]);
	    driver.findElement(By.xpath(xpath)).isDisplayed();

		}
		
		}
		
		ValidateContextMenu valid = new ValidateContextMenu();
		valid.validateContextMenu(driver);
		
		}
		
}
	



