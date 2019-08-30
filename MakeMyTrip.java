package com.java.Datadriven;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.makemytrip.dataallocators.PathAllocators;
import com.atmecs.makemytrip.pageActions.PageActionClick;
import com.java.task.utils.ReadPropertyFile;

public class MakeMyTrip extends ReadPropertyFile {
	WebDriver driver;
	Properties prop=new Properties();
	String cabss;
	PathAllocators path = new PathAllocators();
	

	@BeforeTest
	public void browserInitialize() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David.Easterraj\\Downloads\\My projects\\Workplace\\task1\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		prop = ReadPropertyFile.loadProperty(
				"C:\\Users\\David.Easterraj\\Downloads\\My projects\\Workplace\\task1\\src\\test\\resources\\Resources\\locators\\input.properties");
		/*
		 * try { Alert alert =driver.switchTo().alert(); alert.dismiss();
		 * }catch(Exception e) { e.printStackTrace(); }
		 */
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test
	public void ticket() throws InterruptedException, IOException {
		// path.getData();

		WebElement webcabss = driver.findElement(By.xpath(("(//a[@href='//www.makemytrip.com/cabs/'])[1]")));
		webcabss.click();

		WebElement fromClickk = driver.findElement(By.xpath("	//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[1]/label/span"));
	    fromClickk.click();

		WebElement webfrom = driver.findElement(By.xpath("(//span[@class='sr_city blackText'])[5]"));
        webfrom.click();

		WebElement to = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input"));
		to.click();

		WebElement webto = driver.findElement(By.xpath("(//span[@class='sr_city blackText'])[3]"));
	    webto.click();
		
		WebElement driv2 = driver.findElement(By.xpath("(//div[text()='3'])[2]"));
        driv2.click();

        WebElement webpickupTime = driver.findElement(By.xpath("(//li[text()='10:30'])[2]"));
        webpickupTime.click();
      		  
      		  
        WebElement search = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/p/a"));
   		search.click();
   		
   		WebElement bookCar = driver.findElement(By.xpath("(//span[text()='BOOK NOW'])[2]"));
   		bookCar.click();
   		JavascriptExecutor js = (JavascriptExecutor) driver;
   	
   		
   		WebElement enterAddress = driver.findElement(By.xpath(prop.getProperty("pickUpAddress")));
		enterAddress.click();
		enterAddress.sendKeys(prop.getProperty("pgAddress"));
		
   		WebElement email = driver.findElement(By.xpath("(//input[@class='inputBox '])[2]"));
   		js.executeScript("arguments[0].scrollIntoView();", email);
   		email.sendKeys(prop.getProperty("emailIdi"));
   	
   		
   		WebElement fullName = driver.findElement(By.xpath(prop.getProperty("fullName")));
	    fullName.click();
   		fullName.sendKeys(prop.getProperty("fullName"));



		WebElement phone = driver.findElement(By.xpath(prop.getProperty("phoneNoBox")));
		phone.click();
	    phone.sendKeys(prop.getProperty("phoneNo"));
		
	   
   		
   		
	}
}



