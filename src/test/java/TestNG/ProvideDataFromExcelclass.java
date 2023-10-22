package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.osa.genericUtils.ExcelUtility;

public class ProvideDataFromExcelclass {
//	@Test(dataProviderClass = DataProviderTest.class , dataProvider = "provideDataFromExcel")
//	public void ReadDataFromExcel(String productName, String price, String size) {
//		System.out.println(productName+"--->"+price+"---->"+size);
//	}
	@Test(dataProvider = "ReadDataFromExcel")
	public void gatData(String productName,String price, String size) {
		System.out.println(productName+"--->"+price+"---->"+size);
	}
	
	@DataProvider
	public Object[][] ReadDataFromExcel() throws Throwable {
		ExcelUtility e = new ExcelUtility();
		Object[][] value = e.getMultipleSetOfData("DataProvider");
		return value;
	}
}
