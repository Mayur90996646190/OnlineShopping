package com.osa.Insert_Product_Module;

import java.io.FileInputStream;
import java.io.IOException;
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

public class Insert_Product_ModuleTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream(".\\\\src\\\\test\\\\resources\\\\commondata.properties");
		Properties p =new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String ADURL = p.getProperty("adurl");
		String ADUSERNAME = p.getProperty("adusername");
		String ADPASSWORD = p.getProperty("adpassword");
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\OSA.xlsx");
		Workbook wb =WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Insert Product");
		
		
		
		//Login to the application with admin the credentials 
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ADUSERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ADPASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		//click on insert product
		driver.findElement(By.xpath("//a[@href='insert-product.php']")).click();
		
		String cdd = sh.getRow(2).getCell(2).getStringCellValue();
		//Enter the valid details
		WebElement categoryDropdown = driver.findElement(By.xpath("//select[@name='category']"));
		Select s = new Select(categoryDropdown);
		s.selectByVisibleText(cdd);
		
		String sdd = sh.getRow(3).getCell(3).getStringCellValue();
		WebElement subcategoryDropdown = driver.findElement(By.xpath("//select[@name='subcategory']"));
		Select s1 = new Select(subcategoryDropdown);
		s1.selectByVisibleText(sdd);
		
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
		Select s2=new Select(avaliability);
		s2.selectByValue("In Stock");
		
		
		
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

		//driver.close();
		
	}
}
