package com.qa.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {

	private static String Excel_Path = "src/main/java/com/qa/hubspot/testdata/HubSpot_TestData.xlsx";
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	// private static XSSFRow row;
	// private static XSSFCell cell;
	private static FileInputStream fis;

	public static Object[][] getDataFromExce(String sheetName) {

		Object[][] data = null;
		try {
			fis = new FileInputStream(Excel_Path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}

}
