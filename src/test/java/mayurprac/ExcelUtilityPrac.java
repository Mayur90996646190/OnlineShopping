package mayurprac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.osa.genericUtils.IpathConstants;

public class ExcelUtilityPrac {

	public String readDataFromExcelFile(String sheetname, int cellNo, int rowNo) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String data = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return data;
	}
	
	public void writeDtaIntoExcel(String sheetname, int rowNo, int cellNO, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rowNo).createCell(cellNO).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelpath);
		wb.write(fos);
	}

	public HashMap<String, String> getMultipleDataFromExcel(String sheetname, int keyCol, int valueCol, WebDriver driver,String expected)
			throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rowCount = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <= rowCount; i++) {
			String key = sh.getRow(i).getCell(keyCol).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCol).getStringCellValue();
			map.put(key, value);
		}

		for (Entry<String, String> e : map.entrySet()) {
			driver.findElement(By.name(e.getKey())).sendKeys(e.getValue());
		}
		return map;
	}
	
	public Object[][] getSetOfMultipleData(String sheetname, int keyCol, int valueCol)throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rowCount = sh.getLastRowNum();
		int cellCount = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCount+1][cellCount]; 
		for(int i = 0; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
