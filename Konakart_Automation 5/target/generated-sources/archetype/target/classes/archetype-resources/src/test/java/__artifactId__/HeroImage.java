#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ${package}.konakart_automation.reports.ExtentReport;
import ${package}.konakart_automation.reports.LogReport;
import ${package}.konakart_automation.testbase.BrowserInvoke;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class HeroImage extends BrowserInvoke {

	
	public void HeroImage() throws IOException, InterruptedException, ParseException {

	WebElement elem1=driver.findElement(By.xpath("//picture[@class='slide rounded-corners']/descendant::img"));
	
	
    String element1=	elem1.getAttribute("srcset");
	
    if(element1.contains("https://www.konakart.com/konakart/images/content/home_delonghi.png")) {
    	HeroImageCoffee herocoffee= new HeroImageCoffee();
    	herocoffee.heroImage();
    
    }
    
    	else
    	{
    		HeroImageScenario heroscenario =new HeroImageScenario();
    		heroscenario.HeroImageValidation();
    	}
    driver.close();
    }
    	
    }

	


