package com.osa.AddToCart_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart_Feature_Test {
	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\OSA.xlsx");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD =p.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Login as user
		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[4]/a")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 sign-in']/descendant::input[@name='password']"))
				.sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='login']")).click();

		// click on Search for a product.
		driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("Micromax Canvas Mega 4G");
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		
		//click on the product
		driver.findElement(By.xpath("//a[text()='Micromax Canvas Mega 4G']")).click();
		
		// click on add to cart
		driver.findElement(By.xpath("//div[@class='product-info']/descendant::a[3]")).click();
		Alert a = driver.switchTo().alert();
		String confmsg = a.getText();
		if (confmsg.contains("Product has been added")) {
			System.out.println("Product has been added to the cart");
		} else
			System.out.println("Product has not been added to the cart");
		a.accept();
	}
}
