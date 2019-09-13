package com.atmecs.practo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static File file;
	static String path;

	public static void readFile(String path) throws IOException {
		file = new File(path);
		FileInputStream fileinput = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileinput);
	}

	public int rowCounting(int sheetnum, int rownumber) {
		sheet = workbook.getSheetAt(sheetnum);
		int totalrow = workbook.getSheetAt(sheetnum).getLastRowNum();
		return totalrow;
	}

	public int columnCounting(int sheetnum) {
		int totalcolumn = workbook.getSheetAt(sheetnum).getRow(0).getLastCellNum();
		return totalcolumn;
	}

	public String getData(int sheetnum, int rownum, int cellnum) {
		String data = workbook.getSheetAt(sheetnum).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}

	public static void main(String args[]) {
		ReadExcelFile read = new ReadExcelFile();
	}


}
