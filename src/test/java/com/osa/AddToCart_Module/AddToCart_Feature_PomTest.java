package com.osa.AddToCart_Module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.osa.ObjectRepo.HomePage;
import com.osa.ObjectRepo.LoginPage;
import com.osa.ObjectRepo.SearchResultPage;
import com.osa.genericUtils.DatabaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JAVAUtility;
import com.osa.genericUtils.WebDriverUtility;


public class AddToCart_Feature_PomTest {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		DatabaseUtility dLib = new DatabaseUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JAVAUtility jLib = new JAVAUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		wLib.implicitWait(driver, 10);

		// Login as user
		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[4]/a")).click();
		
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 sign-in']/descendant::input[@name='password']"))
//				.sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[@name='login']")).click();
		LoginPage l = new LoginPage(driver);
		l.LoginUser(USERNAME, PASSWORD);
		
		String prodSearch = "Micromax Canvas Mega 4G";

		// click on Search for a product.
		HomePage h = new HomePage(driver);
		h.getSearchhereTextbox().sendKeys(prodSearch);
		//driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("Micromax Canvas Mega 4G");
		h.getSearchButton().click();
		//driver.findElement(By.xpath("//button[@class='search-button']")).click();
		
		//click on the product
		driver.findElement(By.xpath("//a[text()='"+prodSearch+"']")).click();
		
		// click on add to cart
		//driver.findElement(By.xpath("//div[@class='product-info']/descendant::a[3]")).click();
		SearchResultPage s = new SearchResultPage(driver);
		s.getAddToCartBtn();
		
		
		wLib.acceptAlertPopup(driver, "Product has been added");
	/*	Alert a = driver.switchTo().alert();
		String confmsg = a.getText();
		if (confmsg.contains("Product has been added")) {
			System.out.println("Product has been added to the cart");
		} else
			System.out.println("Product has not been added to the cart");
		a.accept();*/
	}

}
