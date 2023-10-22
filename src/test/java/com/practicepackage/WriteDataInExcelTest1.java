package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelTest1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\WriteData51.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("CompanyDetails");
		
		int countrow = 2;
		int countcell = 2;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < countrow; i++) {
			sh.createRow(i);
			for (int j = 0; j < countcell; j++) {
				int row = i;
				int cell = j;
				System.out.println("Write the data at" + " Row "+row +" and Cell "+cell +"");
				String text = sc.next();
				sh.getRow(i).createCell(j).setCellValue(text);
				
			}
		}
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\WriteData51.xlsx");
		wb.write(fos);
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\WriteData51.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis1);
		Sheet sh1 = wb1.getSheet("CompanyDetails");
		
		for (int i = 0; i < countrow; i++) {
			int lastcell = sh1.getRow(i).getLastCellNum();
			for (int j = 0; j < lastcell; j++) {
				String value = sh1.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}
}
