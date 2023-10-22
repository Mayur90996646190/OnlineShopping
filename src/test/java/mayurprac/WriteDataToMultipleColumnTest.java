package mayurprac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToMultipleColumnTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Writedatainmultirow.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int row = 4;
		int col = 4;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < row; i++) {
			sh.createRow(i);
			for (int j = 0; j < col; j++) {
				System.out.println("Enter the text to be added at row="+i+" and col ="+j+"");
				String text = sc.next();
				sh.getRow(i).createCell(j).setCellValue(text);
			}
		}
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Writedatainmultirow.xlsx");
		wb.write(fos);
		wb.close();

	}
}
