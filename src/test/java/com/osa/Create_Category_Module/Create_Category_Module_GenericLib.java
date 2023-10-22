package com.osa.Create_Category_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.osa.genericUtils.DatabaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JAVAUtility;
import com.osa.genericUtils.WebDriverUtility;

public class Create_Category_Module_GenericLib {
	public static void main(String[] args) throws Throwable {
		DatabaseUtility dLib = new DatabaseUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JAVAUtility jLib = new JAVAUtility();
		FileUtility fLib = new FileUtility();

		WebDriver driver = null;
//		Random ran = new Random();
		int random = jLib.getRandomNum();

		// commondata

		String BROWSER = fLib.getPropertyKeyValue("browser");
		String ADURL = fLib.getPropertyKeyValue("adurl");
		String ADUSERNAME = fLib.getPropertyKeyValue("adusername");
		String ADPASSWORD = fLib.getPropertyKeyValue("adpassword");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else
			System.out.println("Invalid browser");

		driver.get(ADURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Login to the application with user the credentials
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ADUSERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ADPASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();

		// click on category link
		driver.findElement(By.xpath("//a[@href='category.php']")).click();

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
		eLib.getMultipleDataFromExcel("CreateCategory", 0, 1, driver, jLib);

		

		// click on the create button
		driver.findElement(By.xpath("//button[text()='Create']")).click();

		String confirmtext = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

		if (confirmtext.contains("Category Created")) {
			System.out.println("Create Category successfully Created");
		} else
			System.out.println("Create Category is not  successfully Created");

		driver.close();
	}
}
