package com.atmecs.Konakart_Automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.konakart.pageactions.PageActions;
import com.atmecs.konakart_automation.constants.FilePath;
import com.atmecs.konakart_automation.helpers.SortingVerification;
import com.atmecs.konakart_automation.reports.ExtentReport;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;

public class HeroImageCoffee extends BrowserInvoke {
	LogReport log= new LogReport();
	
	@BeforeTest
	public void startReports() {
		startReport();
	}
	
	@Test
public void heroImage() throws IOException, InterruptedException {
	PageActions pageaction = new PageActions();
	PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);
	ExtentReport.logger = ExtentReport.extent.startTest("heroImage");

	WebElement elem =driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage2.image")));
	String xpathtext =elem.getText();
	

	driver.get("https://www.konakart.com/konakart/Home-%26-Garden/Kitchen/DeLonghi/De%27Longhi-BCO-410/DLBCO410/2_33.action");
    
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,1000)");
	
    driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.pdtdesc"))).isSelected();
	
	String actual   = driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.pdtcontent"))).getText();

	String text = "The De'Longhi BCO 410" ;
	
	if(!actual.contains(text)) {
		log.info("Not in the product description page");
	}
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.specs"))).click();
	
	String actual2= driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.specscontent"))).getText();
	
	String text2 =" product specifications here";
	
	if(!actual2.contains(text2)) {
		log.info("Not in the specification page");
	}
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.reviews"))).click();
	
	String actual3= driver.findElement(By.xpath(PropertiesFileReader.getData("loc.page.customerreview"))).getText();
	
	String text3 ="Average Customer Review:";
	
	
	if(!actual3.contains(text3)) {
		log.info("Not in the customer review page");
	}
	SortingVerification sort = new SortingVerification();
	sort.sortingVerify();
	
	
	ExtentReport.logger.log(LogStatus.PASS, "All details are validated");
	driver.quit();
}
}