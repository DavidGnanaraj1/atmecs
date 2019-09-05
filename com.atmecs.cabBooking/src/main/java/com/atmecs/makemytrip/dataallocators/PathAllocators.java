package com.atmecs.makemytrip.dataallocators;

import java.io.IOException;
import java.util.Properties;

import com.java.task.utils.ReadPropertyFile;

public class PathAllocators {
	
	Properties properties;
	public String clickOnCabs;
	
	public String clickOnFromCity;
	
	public void getData() throws IOException {
		
		properties = ReadPropertyFile.loadProperty(
				"C:\\Users\\David.Easterraj\\Downloads\\My projects\\Workplace\\task1\\src\\test\\resources\\Resources\\locators\\input.properties");
		
		setClickOnCabs();
		setClickOnFromCity();
	}
	
	public String getClickOnCabs() {
		return clickOnCabs;
	}

	public void setClickOnCabs() {
		clickOnCabs =properties.getProperty("cabs");
	}
	
	
	public String getClickOnFromCity() {
		return clickOnFromCity;
	}
	public void setClickOnFromCity() {
		clickOnFromCity =properties.getProperty("loc.click.from") ;
	}

	
	
	public static void main(String[] args) throws IOException {
		PathAllocators path=new PathAllocators();
		path.getData();
		
	}

}
