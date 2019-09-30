package com.atmecs.automations.helperpage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.atmecs.automations.reports.LogReport;

import junit.framework.Assert;

public class ValidateBlogDate {


public static void blogSearch(WebDriver driver) throws ParseException {

	
	LocalDate date = LocalDate.now();
//DateTimeFormatter format = DateTimeFormatter.ofPattern();

WebElement elem0 =driver.findElement(By.xpath("//li[@id='menu-item-410']"));
Actions action = new Actions(driver);
action.moveToElement(elem0).build().perform();
driver.findElement(By.xpath("//li[@id='menu-item-938']")).click();

LogReport log = new LogReport();

int i;
int blogcount = driver.findElements(By.xpath("//div[@class='vc_col-sm-12 vc_gitem-col vc_gitem-col-align-']")).size();
String text1 = "(//div[@class='vc_col-sm-12 vc_gitem-col vc_gitem-col-align-'])[";

for( i=1;i<blogcount+1;i++) {
String text2=Integer.toString(i);
String text3="]";

LocalDate date1=date.minusMonths(3);

WebElement elem = driver.findElement(By.xpath(text1+text2+text3));
String datetext=elem.getText();


DateFormat format1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
Date date2 = format1.parse(datetext);
System.out.println(date2);


WebElement elem1 = driver.findElement(By.xpath("//div[@class='vc_gitem-zone vc_gitem-zone-b vc_custom_1419242201096 vc-gitem-zone-height-mode-auto vc_gitem-is-link']"));
LocalDate localDate = Instant.ofEpochMilli(date2.getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
 
if(localDate.isBefore(date1))
{
log.info("Blog met the date criteria");
elem1.click();
break;

}}
WebElement elem2 =driver.findElement(By.xpath("//div[@class='post-entry']"));
String actualtext=elem2.getText();
if(actualtext.contains("Artificial Intelligence")) {
	log.info("BlogTitle verified");
}
//if(date2.compareTo(arg0)
String array[]= {"Home","AI"};
int j;
int index=driver.findElements(By.xpath("//span[@class='breadcrumb']")).size();
for(j=1;j<index;j++) 
{

String jj=Integer.toString(j);
String text11= "(//span[@class='breadcrumb'])[";
String text13="]";

WebElement elem4 =driver.findElement(By.xpath(text11+jj+text13));
String breadcrumb =elem4.getText();

if(!breadcrumb.equals( array[j-1])) 
{
	log.info("Breadcrumb verification failed");
      }
String actualbcrumb=driver.findElement(By.xpath("//span[@class='breadcrumb-current']")).getText();
String breadcrumbtext ="Debunking Myths about AI";
Assert.assertEquals(breadcrumbtext, actualbcrumb);
log.info("Breadcrumb verified");
}



}

}


