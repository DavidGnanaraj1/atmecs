package it.pkg.konakart_automation.helpers;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import it.pkg.konakart.pageactions.PageActions;
import it.pkg.konakart_automation.constants.FilePath;
import it.pkg.konakart_automation.reports.LogReport;
import it.pkg.konakart_automation.testbase.BrowserInvoke;
import it.pkg.konakart_automation.utils.ExcelReader;
import it.pkg.konakart_automation.utils.PropertiesFileReader;
import it.pkg.konakart_automation.utils.TestDataProvider;

public class SearchProductsHelper extends BrowserInvoke{

LogReport log =new LogReport();
	
	
	@Test(dataProvider="konakart",dataProviderClass=TestDataProvider.class)
	public static  void searchProducts(String searchinput,String specificsearch) throws IOException {
		PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);
		ExcelReader readexcel = new ExcelReader(FilePath.TESTDATA_FILE);
		
		WebElement dropdown =driver.findElement(By.xpath(PropertiesFileReader.getData("loc.search.dropdown")));
		
		PageActions pageactions = new PageActions();
		
		pageactions.dropdown("loc.search.dropdown", searchinput);
		
		
		WebElement searchbox=driver.findElement(By.xpath(PropertiesFileReader.getData("loc.search.searchbox")));
		searchbox.sendKeys(specificsearch);

		pageactions.click("loc.search.btn");
		
		
		
	}
}



