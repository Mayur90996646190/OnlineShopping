package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\WriteData51.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("CompanyDetails");
		sh.createRow(10).createCell(0).setCellValue("Zeta");
		FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\WriteData51.xlsx");
		wb.write(fos);	
	}
}
