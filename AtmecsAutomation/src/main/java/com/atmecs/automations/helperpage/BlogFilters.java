package com.atmecs.automations.helperpage;

import java.time.LocalDate;
import java.util.Date;

import com.atmecs.automation.testscripts.Read;

public class BlogFilters {
	   
    
	LocalDate today = LocalDate.now(); 
	int year = today.getYear(); 
	int month = today.getMonthValue();
	int day = today.getDayOfMonth();
	System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);


	LocalDate date1 = LocalDate.of(2014, 01, 14); if(date1.equals(today)){ System.out.printf("Today %s and date1 %s are same date %n", today, date1); }

	/*

	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	String strDate = dateFormat.format(date); 
	     
	     String sDate1="31/12/1998";  
	     String sDate2 = "31-Dec-1998";  
	     String sDate3 = "12 31, 1998";  
	     String sDate4 = "Thu, Dec 31 1998";  
	     String sDate5 = "Thu, Dec 31 1998 23:37:50";  
	     String sDate6 = "31-Dec-1998 23:37:50";  
	     SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
	     SimpleDateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");  
	     SimpleDateFormat formatter3=new SimpleDateFormat("MM dd, yyyy");  
	     SimpleDateFormat formatter4=new SimpleDateFormat("E, MMM dd yyyy");  
	     SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");  
	     SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
	     Date date1=formatter1.parse(sDate1);  
	     Date date2=formatter2.parse(sDate2);  
	     Date date3=formatter3.parse(sDate3);  
	     Date date4=formatter4.parse(sDate4);  
	     Date date5=formatter5.parse(sDate5);  
	     Date date6=formatter6.parse(sDate6);  
	     System.out.println(sDate1+"\t"+date1);  
	     System.out.println(sDate2+"\t"+date2);  
	     System.out.println(sDate3+"\t"+date3);  
	     System.out.println(sDate4+"\t"+date4);  
	     System.out.println(sDate5+"\t"+date5);  
	     System.out.println(sDate6+"\t"+date6);  

	         Date date = Calendar.getInstance().getTime();  
	         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	         String strDate = dateFormat.format(date);  
	         System.out.println("Converted String: " + strDate);  */
	         String string = "January 2, 2010";
	         DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
	         Date date = format.parse(string);
	        System.out.println(date); 
	        
	       //  int year = date.getYear(); // 2010
	        // int day = date.getDayOfMonth(); // 2
	         ////Month month = date.getMonth(); // JANUARY
	         //int monthAsInt = month.getValue(); //
	        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM Q, yyyy", Locale.ENGLISH);
	      //   LocalDate date1 = LocalDate.parse(string, formatter);
	       //  System.out.println(date1);
	    
	   //  DateFormat format1 = new SimpleDateFormat(date);
	     //   Date updateLast = format1.parse(date);
	        public static int daysBetweenUsingJoda(Date d1, Date d2){ return Days.daysBetween( new LocalDate(d1.getTime()), new LocalDate(d2.getTime())).getDays(); }

	        Read more: https:

}
