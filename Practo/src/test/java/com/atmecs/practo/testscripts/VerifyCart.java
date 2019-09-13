package com.atmecs.practo.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.practo.helpers.FilePath;
import com.atmecs.practo.utils.ReadPropertiesFile;

public class VerifyCart extends Login{

	    ReadPropertiesFile readprop= new ReadPropertiesFile();
	
@Test(priority=3)
public void verifyPdtinCart() throws IOException, InterruptedException {
		ReadPropertiesFile readprop= new ReadPropertiesFile();
	    readprop.loadProperty(FilePath.LOCATORS_FILE);
		
	     WebElement fstpdtvol = driver.findElement(By.xpath(readprop.getData(("loc.verifyfirstpdt.size"))));
	     String fstpdtvol1 = fstpdtvol.getText();
		 Assert.assertEquals(fstpdtvol1, "9gm Cream");

		 WebElement fstpdtcmpy = driver.findElement(By.xpath(readprop.getData(("loc.verifyfirstpdt.name"))));
		 String fstpdtcmpy1 = fstpdtcmpy.getText();
		 Assert.assertEquals(fstpdtcmpy1, "Emami Limited");

		 WebElement fstpdtcost = driver.findElement(By.xpath(readprop.getData(("loc.verifyfstpdt.cost"))));
		 String fstpdtcost1 = fstpdtcost.getText();
		 Assert.assertEquals(fstpdtcost1, "30.4");

		 System.out.println("First Medicine details");
		 
	
		 String secmedwgt =  driver.findElement(By.xpath(readprop.getData("loc.verifysecpdt.size"))).getText();
		 Assert.assertEquals(secmedwgt,"80ml"); 
		 
		 String secmedpze =  driver.findElement(By.xpath(readprop.getData("loc.verifysecpdt.cost"))).getText();
	     Assert.assertEquals(secmedpze,"89"); 
	        
	     WebElement secmedimg =  driver.findElement(By.xpath(readprop.getData("loc.verifydetl.secmedimg")));
	     String actsecimg = secmedimg.getAttribute("src");
	     String expsecimg = readprop.getData("loc.verifydetl.expimgsec");	    
	     Assert.assertEquals(secmedpze,"89");
	     
	     System.out.println("Second Medicine details Verified");
	     
	     WebElement totpdtcost = driver.findElement(By.xpath(readprop.getData(("loc.verifytotprz"))));
	
		 String totpdtcost1=totpdtcost.getText();
	
		 Assert.assertEquals(totpdtcost1,"₹238.8");	
	     System.out.println("Total Prize verified");
	
	}
}
