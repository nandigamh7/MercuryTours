package com.mercury.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\nandigam.kumar\\git\\MercuryTours\\MercuryTours\\src\\main\\java\\"
			+ "com\\merccury\\qa\\testdata\\MercuryToursPrjct.xlsx";
	
	static Workbook wb;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) throws Exception{
		FileInputStream file = null;
		file = new FileInputStream(TESTDATA_SHEET_PATH);
		wb = WorkbookFactory.create(file);
		sheet = wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++){
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
}