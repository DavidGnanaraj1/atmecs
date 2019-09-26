package com.atmecs.automations.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.automations.constants.FilePath;

public class ExcelFileReader {
	
		static XSSFWorkbook workbook;
		static XSSFSheet sheet1;
		static File file;
		static String path;

		public ExcelFileReader(String filePath) throws IOException
		{
				File file = new File(filePath);
				FileInputStream fileInput = new FileInputStream(file);
				
				workbook = new XSSFWorkbook(fileInput);
		}

		
		public static String getData(int index, int rowNum, int cellNum) 
		{
			sheet1 = workbook.getSheetAt(index);
			String data = sheet1.getRow(rowNum).getCell(cellNum).getStringCellValue();

			return data;
		}

		
		public int rowCounting(int sheet)
		{
			int rowCount = workbook.getSheetAt(sheet).getLastRowNum();
			System.out.println(" Row Count  is: " + rowCount);
			return rowCount;
		}

		
		public int columnCounting(int sheetIndex) 
		{
			int colCount = workbook.getSheetAt(sheetIndex).getRow(1).getLastCellNum();
             System.out.println("Column count is:"+ colCount);
			return colCount;
		}

		
		public static void main(String[] args) throws IOException 
		
		{
			ExcelFileReader readexcel = new ExcelFileReader(FilePath.TESTDATA_FILE);
			readexcel.rowCounting(0);
			readexcel.columnCounting(0);

		}

	
}


