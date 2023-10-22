package TestNG;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.experimental.theories.DataPoints;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.osa.genericUtils.IpathConstants;



public class DataProviderTest {
	
//	@Test(dataProvider = "tv")
//	public void dataProviderTest(String productName, int price) {
//		System.out.println(productName+"----->"+price);
//	}
//	
	@DataProvider
	public Object[][] tv() {
		Object[][] obj = new Object[4][2];
		
		obj[0][0] = "Samsung";
		obj[0][1] = 100000;
		
		obj[1][0] = "LG";
		obj[1][1] = 50000;
		
		obj[2][0] = "Redmi";
		obj[2][1] = 60000;
		
		return obj;		
	}
	
	@DataProvider
	public Object[][] mobiles() {
		Object[][] obj = new Object[4][2];
		
		obj[0][0] = "RealMe";
		obj[0][1] = 15000;
		
		obj[1][0] = "Iphone";
		obj[1][1] = 80000;
		
		obj[2][0] = "One plus";
		obj[2][1] = 50000;
		
		return obj;
	}
	@DataProvider
	public Object[][] provideDataFromExcel() throws Throwable {
		FileInputStream fis= new FileInputStream(IpathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("DataProvider");
		int lastRow = sh.getLastRowNum();
		int lastCell= sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow+1][lastCell];
		
		for (int i = 0; i <= lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
