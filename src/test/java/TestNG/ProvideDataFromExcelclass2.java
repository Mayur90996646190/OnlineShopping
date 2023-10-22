package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.osa.genericUtils.ExcelUtility;

public class ProvideDataFromExcelclass2 {

	@Test(dataProvider = "dataFromExcel")
	public void getData(String productName, String price, String size)
	{
		System.out.println(productName + price + size);
	}
	
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable {
		ExcelUtility e = new ExcelUtility();
		Object[][] value = e.getMultipleSetOfData("DataProvider");
		return value;
	}
}
