package TestNG;

import org.testng.annotations.Test;

public class DataExcnTest {
	
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "tv")
	
	public void getData(String productName, int price) {
		System.out.println(productName +"---->"+ price);
	}
}
