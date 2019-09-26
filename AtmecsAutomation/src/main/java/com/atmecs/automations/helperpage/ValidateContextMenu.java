package com.atmecs.automations.helperpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import com.atmecs.automations.constants.FilePath;
import com.atmecs.automations.pageactions.PageActionsGet;
import com.atmecs.automations.reports.ExtentReport;
import com.atmecs.automations.reports.LogReport;
import com.atmecs.automations.utils.ExcelFileReader;
import com.atmecs.automations.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class ValidateContextMenu {
	 LogReport log = new LogReport();
	

	public  void validateContextMenu(WebDriver driver) throws IOException {
	
	PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);



	WebElement element = driver.findElement(By.xpath(PropertiesFileReader.getData("loc.homepage.services")));
	
	String actual    =  PageActionsGet.getText(driver, PropertiesFileReader.getData("loc.contextmenu.digitallife"));
	PropertiesFileReader.loadProperty(FilePath.VALIDATION_FILE);
	String expected  =  PropertiesFileReader.getData("expdata.contextmenu.digitallife");
	Assert.assertEquals(expected, actual);
	
	String actual1    =  PageActionsGet.getText(driver, PropertiesFileReader.getData("loc.contextmenu.infrastructure"));
	PropertiesFileReader.loadProperty(FilePath.VALIDATION_FILE);
	String expected1  =  PropertiesFileReader.getData("expdata.contextmenu.infrastructure");
	Assert.assertEquals(expected1, actual1);
	
	log.info("Services Context menu validated");
	
	
	
}
 
}
