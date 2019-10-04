package com.atmecs.konakart_automation.helpers;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.atmecs.konakart.pageactions.PageActions;
import com.atmecs.konakart_automation.reports.LogReport;
import com.atmecs.konakart_automation.testbase.BrowserInvoke;

public class SortingVerification extends BrowserInvoke {
LogReport log = new LogReport();
	public void sortingVerify() throws IOException, InterruptedException {
		PageActions pageaction =new PageActions();
	

		pageaction.dropdown("loc.dropdown", "Rating: low to high");
	Thread.sleep(5000);
	int size=4;
	
	int array[];
	array=new int [10];
	String textfirst="(//div[@class='product-review'])[";
	
	WebElement element = driver.findElement(By.xpath("//div[@class='product-review']"));
	WebElement elementthird =driver.findElement(By.xpath("(//select[@name='orderBy'])[1]"));
	
	
	for(int i=1;i<size;i++)
	{
		int sizesec;
	
		String textsec = Integer.toString(i);
		String textthird = "]";
		String textfourth ="//span[@class='star full']";

		 sizesec = driver.findElements(By.xpath(textfirst+ textsec + textthird+textfourth)).size();
		
		

		array[i-1]=sizesec;
		System.out.println(array[i-1]);
		
	}
	
	for(int i=0;i<size;i++)
	{
		
		if(array[i]<=array[i+1]) {
			log.info("Arranged in  ascending order");
			
		}
	}
	
	
	 pageaction.dropdown("loc.dropdown", "Rating: high to low");
	 int array1[];
	 array1=new int [10];
	 String textfirst1="(//div[@class='product-review'])[";
		WebElement element1 = driver.findElement(By.xpath("//div[@class='product-review']"));
		WebElement elementthird1 =driver.findElement(By.xpath("(//select[@name='orderBy'])[1]"));
		
	int i;
	for(i=1;i<size;i++)
	{
		int sizesec1;
		
		String textsec1 = Integer.toString(i);
		String textthird1 = "]";
		String textfourth1 ="//span[@class='star full']";

		 sizesec1 = driver.findElements(By.xpath(textfirst+ textsec1 + textthird1+textfourth1)).size();
		
		
		array1[i-1]=sizesec1;
		System.out.println(array1[i-1]);
	}
	int size1=4;


		for(int k=1;k<size-1;k++)
		{
			
			if(array1[k-1]>=array1[k]) {
				log.info("Arranged in descending order");
				
			}
		}
		
	}
	
}
