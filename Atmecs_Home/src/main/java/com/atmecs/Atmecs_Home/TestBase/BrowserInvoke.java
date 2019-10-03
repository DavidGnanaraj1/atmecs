package com.atmecs.Atmecs_Home.TestBase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

import com.atmecs.Atmecs_Home.Reports.ExtentReport;
import com.atmecs.Atmecs_Home.Reports.LogReport;
import com.atmecs.Atmecs_Utils.PropertiesFileReader;
import com.atmecs_Atmecs_Home.constants.FilePath;

public class BrowserInvoke extends ExtentReport{
		
	    	LogReport log = new LogReport();
			Properties properties;
			String url;
			String browser;
			
	@BeforeMethod
	public void initializeBrowser() throws Exception {

				properties = PropertiesFileReader.loadProperty(FilePath.CONFIG_FILE);

				url = properties.getProperty("url");
				browser = properties.getProperty("browser");
				
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",FilePath.CHROME_FILE);
					driver = new ChromeDriver();
					log.info("Chrome browser opens");
				} 
				else if (browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver",FilePath.FIREFOX_FILE);
					driver = new FirefoxDriver();
					log.info("Firefox browser opens");
				}
				else if (browser.equalsIgnoreCase("IE")) {
					System.setProperty("webdriver.ie.driver",FilePath.IE_FILE);
					driver = new InternetExplorerDriver();
					log.info("IE browser opens");
				}

			
				driver.get(url);
				log.info("Application is open");
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}
		}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

