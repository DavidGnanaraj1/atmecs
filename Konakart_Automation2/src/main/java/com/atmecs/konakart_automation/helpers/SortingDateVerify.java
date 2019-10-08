package com.atmecs.konakart_automation.helpers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.konakart.pageactions.PageActions;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.testbase.BrowserInvoke;

public class SortingDateVerify extends BrowserInvoke{
	LogReport log = new LogReport();

	public void sortingDate() throws IOException, InterruptedException, ParseException {

		PageActions pageaction = new PageActions();
		pageaction.dropdown("loc.dropdown", "Rating: high to low");
		Thread.sleep(3000);
		//Oldest first                       
		int size = 4;
		int i;
		int date[] = new int[size];
		int year[] = new int [size];
		int month[] = new int [size];
		String date11[] = new String [size];
		WebElement element;
		for (i = 1; i <= 4; i++) {

			String text1 = "(//span[@class='product-review-details-date'])[";
			String text2 = Integer.toString(i);
			String text3 = "]";

			
			 element = driver.findElement(By.xpath(text1 + text2 + text3));

			String elemtext = element.getText();

			Date date1;
			SimpleDateFormat input = new SimpleDateFormat(" dd MMMM yyyy");
			 SimpleDateFormat output= new SimpleDateFormat("yyyy-MM-dd");
			date1 = input.parse(elemtext);

            
            date11[i-1]=output.format(date1);
	
			
     }
		String sort[]=new String [size];
		for(int j=0;j<date11.length;j++) {
			  
			
			
			  Date date1;
			  Date date2;
		 
			 
			   date1=new SimpleDateFormat("yyyy-MM-dd").parse(date11[j]);  
               date2=new SimpleDateFormat("yyyy-MM-dd").parse(date11[j+1]);  
               if(date1.before(date2)) {
               log.info("Arranged in oldest fist");
               }
               if(date1.after(date2)) {
            	  log.info("Not in Oldest first");
               }
               

		     
 	}
		
		
}
	public void sortingDate2() throws IOException, ParseException, InterruptedException {
		PageActions pageaction = new PageActions();
		pageaction.dropdown("loc.dropdown", "Rating: high to low");
		Thread.sleep(3000);

                   
		int size = 4;
		int i;
		int date1[] = new int[size];
		int year1[] = new int [size];
		int month1[] = new int [size];
		String date111[] = new String [size];
		WebElement element;
		for (i = 1; i <= 4; i++) {

			String text1 = "(//span[@class='product-review-details-date'])[";
			String text2 = Integer.toString(i);
			String text3 = "]";

			
			 element = driver.findElement(By.xpath(text1 + text2 + text3));

			String elemtext = element.getText();

			Date date11;
			SimpleDateFormat input = new SimpleDateFormat("E dd MMMM yyyy");
			SimpleDateFormat output= new SimpleDateFormat("yyyy-MM-dd");
			date11 = input.parse(elemtext);

            
            date111[i-1]=output.format(date1);
	
			
     }
		String sort1[]=new String [size];
		for(int j=0;j<date111.length;j++) {
			  
			
			
			  Date date11;
			  Date date21;
		 
			 
			   date11=new SimpleDateFormat("yyyy-MM-dd").parse(date111[j]);  
               date21=new SimpleDateFormat("yyyy-MM-dd").parse(date111[j+1]);  
               if(date11.after(date21)) {
            	   log.info("Arranged in oldest fist");
               }
               
               if(date11.before(date21)) {
            	  log.info("Not in Oldest first");
               }
               

		     
 	}
		
		
		
	}
}