package com.atmecs.Konakart_Automation;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
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
		ExtentReport.logger = ExtentReport.extent.startTest("searchValidation");
	
		
		//SearchProductsHelper.searchProducts ("Games","The Wheel Of Time");
		//		String actual=driver.findElement(By.xpath(PropertiesFileReader.getData("loc.verify.gametitle"))).getText();
//		String expected = "The Wheel Of Time";
//		Assert.assertEquals(actual, expected);
		
		SearchProductsHelper.searchProducts("Electronics", "Samsung Phones");
		
		//Negative scenario
		SearchProductsHelper.searchProducts("Electronics", "Pendrives");
		
		Boolean negscen=driver.findElement(By.xpath("//div[contains(text(),'There are no available products')]")).isDisplayed();
		
		if(negscen==true) {
			log.info("product unavailability message verified");
		}
		
		ExtentReport.logger.log(LogStatus.PASS, "All details are validated"); 
	}


	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
