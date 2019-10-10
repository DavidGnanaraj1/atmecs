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
		pageaction.dropdown("loc.dropdown", "Oldest first");
		Thread.sleep(3000);
	                   
		int size = 4;
		int i;
		int date[] = new int[size];
		int year[] = new int [size];
		int month[] = new int [size];
		String date11[] = new String [size];
		WebElement element;
		String sort[]=new String [size];
		String elemtext1;
		
		for (i = 1; i <= 4; i++) {

			String text1 = "(//span[@class='product-review-details-date'])[";
			String text2 = Integer.toString(i);
			String text3 = "]";
			element = driver.findElement(By.xpath(text1 + text2 + text3));

			String elemtext = element.getText();
			
			String[] words=null;
			words=elemtext.split("\\s");
			int wordint=Integer.parseInt(words[1]);
			Date date1;
			SimpleDateFormat input = new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat output;
			
			if(wordint<10) {
			//	words[5]="0";
			//	words[4]=words[5]+words[1];
				String elemtext12= words[1]+" "+words[2]+" "+words[3];
				output= new SimpleDateFormat("yyyy-MM-dd");
				date1 = input.parse(elemtext12);
			}
			
			else {
				String elemtext11= words[1]+" "+words[2]+" "+words[3];
				output= new SimpleDateFormat("yyyy-MM-dd");
				date1 = input.parse(elemtext11);
				
			}

			String inputarr[]=new String [10];
		
            date11[i-1]=output.format(date1);
	
			
     }
		
		
		for(int j=0;j<(date11.length)-1;j++) {
			  
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
		pageaction.dropdown("loc.dropdown", "Most recent first");
		Thread.sleep(3000);
	                   
		int size = 4;
		int i;
		int date[] = new int[size];
		int year[] = new int [size];
		int month[] = new int [size];
		String date11[] = new String [size];
		WebElement element;
		String sort[]=new String [size];
		String elemtext1;
		
		for (i = 1; i <= 4; i++) {

			String text1 = "(//span[@class='product-review-details-date'])[";
			String text2 = Integer.toString(i);
			String text3 = "]";
			element = driver.findElement(By.xpath(text1 + text2 + text3));

			String elemtext = element.getText();
			
			String[] words=new String [10];
			words=elemtext.split("\\s");
			int wordint=Integer.parseInt(words[1]);
			Date date1;
			SimpleDateFormat input = new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat output;
			
			if(wordint<10) {
		
				String elemtext12= words[1]+" "+words[2]+" "+words[3];
				output= new SimpleDateFormat("yyyy-MM-dd");
				date1 = input.parse(elemtext12);
			}
			
			else {
				String elemtext11= words[1]+" "+words[2]+" "+words[3];
				output= new SimpleDateFormat("yyyy-MM-dd");
				date1 = input.parse(elemtext11);
				
			}
		
			String inputarr[]=new String [10];
		
            date11[i-1]=output.format(date1);
	
			
     }
		
		
		for(int j=0;j<(date11.length)-1;j++) {
			  
			  Date date1;
			  Date date2;
		 
			 
			   date1=new SimpleDateFormat("yyyy-MM-dd").parse(date11[j]);  
               date2=new SimpleDateFormat("yyyy-MM-dd").parse(date11[j+1]);  
               if(date2.before(date1)) {
               log.info("Arranged in Most Recent fist");
               }
               if(date2.after(date1)) {
            	  log.info("Not in Most Recent first");
               }
               

		     
 	}
		
		
}
		     
 	
		
		
		
	}