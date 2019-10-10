package com.atmecs.Konakart_Automation;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.konakart_automation.helpers.SearchProductsHelper;
import com.atmecs.konakart_automation.helpers.SortingDateVerify;
import com.atmecs.konakart_automation.reports.ExtentReport;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.testbase.BrowserInvoke;
import com.atmecs.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;


public class SearchValidation extends BrowserInvoke{
	LogReport log = new LogReport();

	
@BeforeTest
	public void startReports() {
		startReport();
	}

@Test
	public void searchValidation() throws IOException, InterruptedException, ParseException {
		ExtentReport.exttest = ExtentReport.extent.startTest("searchValidation");
	
		

		
		SearchProductsHelper.searchProducts("Games", "The Wheel Of Time");
		String elem=driver.findElement(By.xpath(PropertiesFileReader.getData("loc.games"))).getText();
		if(elem.contains("The Wheel Of Time")) {
			log.info("Games validated");
		}
		//Negative scenario
		SearchProductsHelper.searchProducts("Electronics", "Pendrives");
		
		Boolean negscen=driver.findElement(By.xpath(PropertiesFileReader.getData("loc.unavlble"))).isDisplayed();
		
		if(negscen==true) {
			log.info("product unavailability message verified");
		}
		driver.findElement(By.xpath(PropertiesFileReader.getData("loc.homebc"))).click();
		Thread.sleep(3000);
		
		HeroImage  heroimage = new HeroImage();
		heroimage.HeroImage();
		ExtentReport.exttest.log(LogStatus.PASS, "All details are validated"); 
		driver.close();
	}	
}
