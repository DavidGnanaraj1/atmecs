package com.atmecs.automations.helperpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	
	//PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);
	String actual    = driver.findElement(By.xpath("//li[@id='menu-item-269']")).getText();
    log.info(actual);
	PropertiesFileReader.loadProperty(FilePath.VALIDATION_FILE);
	String expected  =  PropertiesFileReader.getData("expdata.contextmenu.digitallife");
	Assert.assertEquals(expected, actual);
	
	
    String  actual1    =  driver.findElement(By.xpath("//li[@class='menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-562']")).getText();
	action.moveToElement(element).build().perform();
    
	PropertiesFileReader.loadProperty(FilePath.VALIDATION_FILE);
	String expected1  =  PropertiesFileReader.getData("expdata.contextmenu.infrastructure");
	Assert.assertEquals(expected1, actual1);
	
	log.info("Services Context menu validated");
	
	
	
}
 
}
