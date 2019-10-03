package com.atmecs.AtmecsProject2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BreadCrumb extends BrowserInvoke {

	public static void breadCrumb(WebDriver driver, int rownum) throws IOException {
		LogReport log = new LogReport();
		ExcelReader read = new ExcelReader(FilePath.TESTDATA_FILE);
		PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);

		int j;
		int index = driver.findElements(By.xpath(PropertiesFileReader.getData("loc.blog.index"))).size();

		String array[] = { "Home", "Services", "Digital Life" };

		for (j = 1; j < index; j++) {

			String jj = Integer.toString(j);
			String text11 = PropertiesFileReader.getData("loc.blog.text11");
			String text13 = "]";

			WebElement elem4 = driver.findElement(By.xpath(text11 + jj + text13));
			String breadcrumb = elem4.getText();

			if (!breadcrumb.equals(array[j - 1])) {
				log.info("Breadcrumb verification failed");
			}
			WebElement elem5 = driver.findElement(By.xpath(PropertiesFileReader.getData("loc.blog.breadcrumb")));
			String actualbcrumb = elem5.getText();
			ExcelReader read1 = new ExcelReader(FilePath.TESTDATA_FILE);
			String breadcrumbtext = ExcelReader.getData(0, rownum, 0);
			Assert.assertEquals(actualbcrumb, breadcrumbtext);
			log.info("Breadcrumb verified");
		}

	}

}
