package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelMultiRowTest2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Writedatainmultirow.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet  sh= wb.getSheet("Sheet1");
		sh.createRow(0).createCell(0).setCellValue("Qspider");
		sh.getRow(0).createCell(1).setCellValue("bangalore");
		FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\Writedatainmultirow.xlsx");
		wb.write(fos);
		System.out.println("Written the data");
		}
}
