package com.osa.Create_Category_Module;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Category_Module {
	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		Random ran = new Random();
		int random = ran.nextInt(500);
		//commondata
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String ADURL = p.getProperty("adurl");
		String ADUSERNAME = p.getProperty("adusername");
		String ADPASSWORD = p.getProperty("adpassword");
		
		//Excel data
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\OSA.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("CreateCategory");
		
		
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else 
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

		int count = sh.getRow(0).getLastCellNum();
		//Hashmap
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=1; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		for(Entry<String, String> s : map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
//		// fill all the details
//		driver.findElement(By.name("category")).sendKeys("Healthfy");
//
//		driver.findElement(By.name("description")).sendKeys("health and nutrition");

		// click on the create button
		driver.findElement(By.xpath("//button[text()='Create']")).click();

		String confirmtext = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

		if (confirmtext.contains("Category Created")) {
			System.out.println("Create Category successfully Created");
		} else
			System.out.println("Create Category is not  successfully Created");

		//driver.close();
	}
}
