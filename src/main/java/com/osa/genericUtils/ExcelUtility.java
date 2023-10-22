package com.osa.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

/**
 * This class having all the methods of excel file
 */
public class ExcelUtility {
	/**
	 * This method used to read the data from excel sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;
	}

	/**
	 * This method is used to write the data in the excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeIntoTheExcel(String sheetName, int rowNum, int cellNum, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(sheetName);
		Row row = sh.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelpath);
		workbook.write(fos);
		workbook.close();
	}

	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(sheetName);
		int row = sh.getLastRowNum();
		return row;
	}

	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyColumn, int valueColumn,
			WebDriver driver, JAVAUtility jLib) throws Throwable {
		FileInputStream fi = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);

		int count = sh.getLastRowNum();
		// Hashmap
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <= count; i++) {
			String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
		}

		for (Entry<String, String> s : map.entrySet()) {

			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue() + jLib.getRandomNum());
		}

		return map;
	}
	
	@DataProvider
	public Object[][] getMultipleSetOfData(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow + 1][lastCell];
		for (int i = 0; i <= lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
