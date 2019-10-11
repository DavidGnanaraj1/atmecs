#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ${package}.konakart.pageactions.PageActions;
import ${package}.konakart_automation.constants.FilePath;
import ${package}.konakart_automation.helpers.SortingDateVerify;
import ${package}.konakart_automation.helpers.SortingVerification;
import ${package}.konakart_automation.reports.ExtentReport;
import ${package}.konakart_automation.reports.LogReport;
import ${package}.konakart_automation.testbase.BrowserInvoke;
import ${package}.konakart_automation.utils.PropertiesFileReader;
import com.relevantcodes.extentreports.LogStatus;

public class HeroImageScenario extends BrowserInvoke {
	
LogReport log = new LogReport();
	
 
	public void HeroImageValidation() throws IOException, InterruptedException, ParseException {
		
		PageActions pageaction = new PageActions();
		PropertiesFileReader.loadProperty(FilePath.LOCATORS_FILE);
	
	
		driver.findElement(By.xpath("//img[@srcset='https://www.konakart.com/konakart/images/content/home_kindle-fire-hd.jpg']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,800)");
		
	    driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.pdtdesc"))).isSelected();
		
		String actual   = driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.pdtcontent"))).getText();

		String text = "World's most advanced 7${symbol_escape}" tablet" ;
		
		if(!actual.contains(text)) {
			log.info("Not in the product description page");
		}
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.specs"))).click();
		
		String actual2= driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.specscontent"))).getText();
		
		String text2 =" product specifications here";
		
		if(!actual2.contains(text2)) {
			log.info("Not in the specification page");
		}
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(PropertiesFileReader.getData("loc.heroimage.reviews"))).click();
		
		String actual3= driver.findElement(By.xpath(PropertiesFileReader.getData("loc.page.customerreview"))).getText();
		
		String text3 ="Average Customer Review:";
		
		
		
		if(!actual3.contains(text3)) {
			log.info("Not in the customer review page");
		}
		
		SortingDateVerify sort1 = new SortingDateVerify();
		sort1.sortingDate();
		sort1.sortingDate2();
		SortingVerification sort = new SortingVerification();
		sort.sortingVerify();
		
		
		
		
	}
	
}
