package com.atmecs.practo.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.practo.testbase.ChoosingBrowser;
import com.atmecs.practo.utils.ReadPropertiesFile;

public class Click extends ChoosingBrowser {

	

	public static void clickElements(String keys) throws IOException {
		ReadPropertiesFile read = new ReadPropertiesFile();
		String locators = read.getData(keys);
		 WebElement elements = driver.findElement(By.xpath(locators));
		elements.click();
	}

	public static void enterValues(String keys,String valuestoentered) throws IOException {
		ReadPropertiesFile read = new ReadPropertiesFile();
		String locators = read.getData(keys);
		 WebElement elements1 = driver.findElement(By.xpath(locators));
		elements1.sendKeys(valuestoentered);
	}

}