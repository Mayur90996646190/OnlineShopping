package mayurprac;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultipleColumnTest1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\TestData51.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("CompaniesDetails");
		
		int countRow=sh.getLastRowNum();
		for (int i = 1; i <= countRow; i++) {
			int countCell = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < countCell; j++) {
				String value=sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value + " ");
			}
			System.out.println();
		}
		wb.close();
	}
}
