package com.osa.Create_Category_Module;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.osa.ObjectRepo.AdminHompage;
import com.osa.ObjectRepo.CreateCategoryPage;
import com.osa.genericUtils.BaseClass;
@Listeners(com.osa.genericUtils.ListenerImplementationClass.class)
public class Create_Category_Module_FromBaseClass extends BaseClass {
	
	@Test(groups="smoke")
	public void createCategory() throws Throwable {

		// click on category link
		//driver.findElement(By.xpath("//a[@href='category.php']")).click();
		AdminHompage ah = new AdminHompage(driver);
		ah.getCreate_CategoryLink().click();
		

//		// Excel data
//		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\OSA.xlsx");
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet("CreateCategory");
//
//		int count = sh.getRow(0).getLastCellNum();
//		// Hashmap
//		HashMap<String, String> map = new HashMap<String, String>();
//		for (int i = 1; i <= count; i++) {
//			String key = sh.getRow(i).getCell(0).getStringCellValue();
//			String value = sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//		}
//
//		for (Entry<String, String> s : map.entrySet()) {
//			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
//		}
		
		//eLib.getMultipleDataFromExcel("CreateCategory", 0, 1, driver, jLib);
		CreateCategoryPage cc = new CreateCategoryPage(driver);
		cc.createCategory(driver, eLib.getMultipleDataFromExcel("CreateCategory", 0, 1, driver, jLib));

		
		cc.getCreateBtn().click();

		String confirmtext = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

		if (confirmtext.contains("Category Created")) {
			System.out.println("Create Category successfully Created");
		} else
			System.out.println("Create Category is not  successfully Created");
	}
}
