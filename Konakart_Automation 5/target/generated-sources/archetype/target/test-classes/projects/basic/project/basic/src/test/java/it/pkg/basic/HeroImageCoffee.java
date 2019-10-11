package it.pkg.basic;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import it.pkg.konakart.pageactions.PageActions;
import it.pkg.konakart_automation.constants.FilePath;
import it.pkg.konakart_automation.helpers.SortingDateVerify;
import it.pkg.konakart_automation.helpers.SortingVerification;
import it.pkg.konakart_automation.reports.ExtentReport;
import it.pkg.konakart_automation.reports.LogReport;
import it.pkg.konakart_automation.testbase.BrowserInvoke;
import it.pkg.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;

public class HeroImageCoffee extends BrowserInvoke {
	
	LogReport log= new LogReport();
	
	
public void heroImage() throws IOException, InterruptedException, ParseException {
	
	PageActions pageaction = new PageActions();
	PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);


	driver.findElement(By.xpath("//img[@srcset='https://www.konakart.com/konakart/images/content/home_delonghi.png']")).click();
	Thread.sleep(3000);
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
	
	SortingDateVerify sortdate= new SortingDateVerify();
	sortdate.sortingDate();
	sortdate.sortingDate2();
	

	
}
}