package com.atmecs.AtmecsProject2;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.Atmecs_Home.Reports.ExtentReport;
import com.atmecs.Atmecs_Home.Reports.LogReport;
import com.atmecs.Atmecs_Home.TestBase.BrowserInvoke;
import com.atmecs.Atmecs_Home_Helpers.BreadCrumb;

import com.atmecs.Atmecs_Utils.PropertiesFileReader;
import com.atmecs_Atmecs_Home.constants.FilePath;
import com.relevantcodes.extentreports.LogStatus;

public class PageVerification extends BrowserInvoke {
	LogReport log = new LogReport();

	String url = "http://atmecs.com/";

	@BeforeTest
	public void startReports() {
		startReport();
	}
	
	@Test
	public void goToReadMore() throws InterruptedException, IOException {
		ExtentReport.logger = ExtentReport.extent.startTest("goToReadMore");
        PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);
		driver.findElement(By.linkText("Explore Now!")).click();
		String actual5 = driver.getTitle();
		String expected5 = "Services | Atmecs, Inc. | Digital Solutions & Product Engineering Services";
		Assert.assertEquals(actual5, expected5);
		driver.get(url);

		Thread.sleep(3000);

		WebElement elem0 = driver.findElement(By.xpath(PropertiesFileReader.getData("loc.text.elem0")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		elem0.click();
		String actual = driver.getTitle();

		String expected = PropertiesFileReader.getData("loc.expected");
		Assert.assertEquals(actual, expected);
		BreadCrumb.breadCrumb(driver, 1);
		log.info("Breadcrumb verified");
		driver.get(url);

		WebElement elem1 = driver.findElement(By.xpath(
				PropertiesFileReader.getData("loc.text.elem1")));
		js.executeScript("window.scrollBy(0,1250)");
		
		elem1.click();
		String actual1 = driver.getTitle();
		String expected1 = PropertiesFileReader.getData("loc.expected1");
		Assert.assertEquals(actual1, expected1);
		BreadCrumb.breadCrumb(driver, 2);
		log.info("Breadcrumb verified");
		driver.get(url);
		

		WebElement elem2 = driver.findElement(
				By.xpath(PropertiesFileReader.getData("loc.elem2")));
		js.executeScript("window.scrollBy(0,1450)");

		elem2.click();
		String actual2 = driver.getTitle();
		String expected2 = PropertiesFileReader.getData("loc.expected2");
		Assert.assertEquals(actual2, expected2);
		BreadCrumb.breadCrumb(driver, 3);
		log.info("Breadcrumb verified");
		driver.get(url);

		WebElement elem3 = driver.findElement(By.xpath(
				PropertiesFileReader.getData("loc.elem3")));
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1470)");

		elem3.click();
		String actual3 = driver.getTitle();
		String expected3 = PropertiesFileReader.getData("loc.expected3");
		Assert.assertEquals(actual3, expected3);
		BreadCrumb.breadCrumb(driver, 4);
		log.info("Breadcrumb verified");
		driver.get(url);

		WebElement elem4 = driver
				.findElement(By.xpath(PropertiesFileReader.getData("loc.elem4")));
		js.executeScript("window.scrollBy(0,1600)");

		elem4.click();
		
		String actual4 = driver.getTitle();
		String expected4 =PropertiesFileReader.getData("loc.text4");
		Assert.assertEquals(actual4, expected4);
		BreadCrumb.breadCrumb(driver, 5);
		log.info("Breadcrumb verified");
		driver.get(url);

		driver.quit();
		ExtentReport.logger.log(LogStatus.PASS, "All breadcrumb are validated"); 
	}

}
