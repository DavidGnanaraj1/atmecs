package it.pkg.konakart.pageactions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import it.pkg.konakart_automation.testbase.BrowserInvoke;
import it.pkg.konakart_automation.utils.PropertiesFileReader;

public class PageActions extends BrowserInvoke {
	
	
	public  void click( String locator) throws IOException {
    
		driver.findElement(By.xpath(PropertiesFileReader.getData(locator))).click();
	}
	
	


	public  void dropdown( String locator, String value) throws IOException {
		
	
		WebElement element = driver.findElement(By.xpath(PropertiesFileReader.getData(locator)));
		Select select = new Select(element);
	
		select.selectByVisibleText(value);

	
	}
	
	
	public  void sendKeys( String locator, String value) {
	
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
		

	}
	
}
