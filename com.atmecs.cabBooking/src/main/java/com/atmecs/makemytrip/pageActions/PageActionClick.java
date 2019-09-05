package com.atmecs.makemytrip.pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageActionClick {
public static void ClickOnElement(WebDriver driver,String xpath) {
	driver.findElement(By.xpath(xpath)).click();
	}
}
