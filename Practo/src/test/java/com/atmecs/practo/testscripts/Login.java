package com.atmecs.practo.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.atmecs.practo.helpers.FilePath;
import com.atmecs.practo.testbase.ChoosingBrowser;
import com.atmecs.practo.utils.ReadExcelFile;
import com.atmecs.practo.utils.ReadPropertiesFile;

public class Login extends ChoosingBrowser {

		ReadPropertiesFile readprop = new ReadPropertiesFile();
	    ReadExcelFile read = new ReadExcelFile();
	
	    Logger log = Logger.getLogger(Login.class);

@Test(priority = 0)
public void verifyHomePage() throws IOException, InterruptedException {
		ChoosingBrowser.browserInvoke();
        log.info("opening website");

		readprop.loadProperty(FilePath.LOCATORS_FILE);
		ReadExcelFile.readFile(FilePath.TESTDATA_FILE);
        
		Click.clickElements("loc.login.clicklogin");
	

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(readprop.getData("loc.login.emailtxtbox")))).click();

		WebElement mail=driver.findElement(By.xpath(readprop.getData("loc.login.emailtxtbox")));
		mail.sendKeys(read.getData(0, 0, 0));
        
		
        WebElement psswrdtxtbox = driver.findElement(By.xpath(readprop.getData("loc.login.passwrdtxtbox")));
		psswrdtxtbox.click();
		psswrdtxtbox.sendKeys(read.getData(0, 0, 1));

		Click.clickElements("loc.login.submitlogin");
		
        readprop.loadProperty(FilePath.EXPECTEDDATA_FILE);
		
        String exptdTitle = readprop.getData("homepagetitle");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, exptdTitle);
		}


@Test(priority = 1)
public void verifyPainrelfPage() throws IOException, InterruptedException {

		ReadPropertiesFile readprop = new ReadPropertiesFile();
		readprop.loadProperty(FilePath.LOCATORS_FILE);

		driver.findElement(By.xpath(readprop.getData("loc.srchmed.clickpharamacy"))).click();
		driver.findElement(By.xpath(readprop.getData("loc.srchmed.clickpainrelf"))).click();

		for (String winhandle : driver.getWindowHandles()) {
			driver.switchTo().window(winhandle);
		}
		
		readprop.loadProperty(FilePath.EXPECTEDDATA_FILE);
		String exptdTitle = readprop.getData("painreliefpagetitle");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, exptdTitle);
		Thread.sleep(3000);
	}

@Test(priority = 2)
public void verifyFirstProduct() throws Exception {

		ReadPropertiesFile readprop = new ReadPropertiesFile();
		readprop.loadProperty(FilePath.LOCATORS_FILE);
		WebElement srchbx = driver.findElement(By.xpath(readprop.getData("loc.srchmed.srcbox")));
		srchbx.click();
		srchbx.sendKeys(readprop.getData("firstmed"));

		driver.findElement(By.xpath(readprop.getData("loc.srchmed.addtocart"))).click();
		driver.findElement(By.xpath(readprop.getData("loc.medqty.clickplus"))).click();

		WebElement srchbx1;
		srchbx1 = driver.findElement(By.xpath(readprop.getData("loc.srchmed.srcbox")));
		srchbx1.click();
		srchbx1.clear();
        Thread.sleep(3000);
		srchbx.sendKeys(readprop.getData("secmed"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(readprop.getData("loc.srchmed.addtocart2"))).click();
		
		driver.findElement(By.xpath(readprop.getData("loc.medqty.secclickplus"))).click();
		driver.findElement(By.xpath(readprop.getData("loc.addtocart.clkviewcart"))).click();
		driver.findElement(By.xpath(readprop.getData("loc.cart.homepage"))).click();
		}

}
