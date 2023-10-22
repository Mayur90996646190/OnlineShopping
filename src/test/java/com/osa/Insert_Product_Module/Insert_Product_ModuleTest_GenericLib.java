package com.osa.Insert_Product_Module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.osa.genericUtils.DatabaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JAVAUtility;
import com.osa.genericUtils.WebDriverUtility;

public class Insert_Product_ModuleTest_GenericLib {
	public static void main(String[] args) throws Throwable {
		
		DatabaseUtility dLib = new DatabaseUtility();
        WebDriverUtility wLib = new WebDriverUtility();
        ExcelUtility eLib = new ExcelUtility();
        JAVAUtility jLib = new JAVAUtility();
        FileUtility fLib = new FileUtility();
        
//		FileInputStream fis = new FileInputStream(".\\\\src\\\\test\\\\resources\\\\commondata.properties");
//		Properties p =new Properties();
//		p.load(fis);
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String ADURL = fLib.getPropertyKeyValue("adurl");
		String ADUSERNAME = fLib.getPropertyKeyValue("adusername");
		String ADPASSWORD = fLib.getPropertyKeyValue("adpassword");
		
		WebDriver driver = new ChromeDriver();
		driver.get(ADURL);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wLib.implicitWait(driver, 10);
		
		//driver.manage().window().maximize();
		wLib.maximizeTheBrowser(driver);
		
		
		//Login to the application with admin the credentials 
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ADUSERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ADPASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		//click on insert product
		driver.findElement(By.xpath("//a[@href='insert-product.php']")).click();
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\OSA.xlsx");
		Workbook wb =WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Insert Product");
//		String cdd = sh.getRow(2).getCell(2).getStringCellValue();
		
		String cdd=eLib.readDataFromExcelSheet("Insert Product", 2, 2);
		
		
		//Enter the valid details
	    WebElement categoryDropdown = driver.findElement(By.xpath("//select[@name='category']"));
//		Select s = new Select(categoryDropdown);
//		s.selectByVisibleText(cdd);
		wLib.selectDropDownByVisibleText(categoryDropdown, cdd);
		
		String sdd = eLib.readDataFromExcelSheet("Insert Product", 3, 3);
		
		WebElement subcategoryDropdown = driver.findElement(By.xpath("//select[@name='subcategory']"));
//		Select s1 = new Select(subcategoryDropdown);
//		s1.selectByVisibleText(sdd);
		wLib.selectDropDownByVisibleText(subcategoryDropdown, sdd);
		
		HashMap<String, String> map = new HashMap<String, String>();
		int count = sh.getLastRowNum();
		for(int i=1; i<=count; i++)
		{
			String key =sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> s3 : map.entrySet())
		{
			driver.findElement(By.name(s3.getKey())).sendKeys(s3.getValue());
		}
		//eLib.getMultipleDataFromExcel("Insert Product", 0, 1, driver, jLib);
//		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys("shorts dtrss product");
//		
//		driver.findElement(By.xpath("//input[@name='productCompany']")).sendKeys("Westside Product Price");
		
//		driver.findElement(By.xpath("//input[@name='productpricebd']")).sendKeys("2000");
//		
//		driver.findElement(By.xpath("//input[@name='productprice']")).sendKeys("1500");
//		
//		driver.findElement(By.xpath("//textarea[@name='productDescription']")).sendKeys("colourful dress");
//		
//		driver.findElement(By.xpath("//input[@name='productShippingcharge']")).sendKeys("200");
//		
		WebElement avaliability = driver.findElement(By.xpath("//select[@name='productAvailability']"));
//		Select s2=new Select(avaliability);
//		s2.selectByValue("In Stock");
		wLib.selectDropDownByValue(avaliability, "In Stock");
		
		
		//File f = new File(".\\SS of Onlineshoapp\\laptop.jpg");
		//String path = f.getAbsolutePath();
//		driver.findElement(By.xpath("//input[@name='productimage1']")).sendKeys("C:\\SS of Onlineshoapp\\laptop.jpg");
//		driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys("C:\\SS of Onlineshoapp\\laptop.jpg");
//		driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys("C:\\SS of Onlineshoapp\\laptop.jpg");

		//Click on insert button
		driver.findElement(By.xpath("//button[text()='Insert']")).click();
		String confirmtext=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

		if(confirmtext.contains("Product Inserted Successfully"))
		{
			System.out.println("Product is inserted to the Category successfully");
		}
		else
			System.out.println("Product is not inserted to the Category successfully ");

	//	driver.close();
		
	}
}
