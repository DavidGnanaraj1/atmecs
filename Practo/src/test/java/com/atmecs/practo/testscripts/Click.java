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
		driver.findElement(By.xpath(read.getData(keys))).click();
	}

	public static void enterValues(String keys,String valuestoenter) throws IOException {
		ReadPropertiesFile read = new ReadPropertiesFile();
	
		 WebElement elements1 = driver.findElement(By.xpath(read.getData(keys)));
		elements1.sendKeys(valuestoenter);
	}

}

