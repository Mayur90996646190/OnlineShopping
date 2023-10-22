package com.osa.AddToCart_Module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.osa.ObjectRepo.HomePage;
import com.osa.ObjectRepo.SearchResultPage;
import com.osa.genericUtils.BaseClass;


public class AddToCart_Feature_FromBaseClass extends BaseClass{
	@Test
	public  void  test() throws InterruptedException, IOException {

		// Login as user
		
		
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 sign-in']/descendant::input[@name='password']"))
//				.sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[@name='login']")).click();
	
		String prodSearch = "Micromax Canvas Mega 4G";

		// click on Search for a product.
		HomePage h = new HomePage(driver);
		h.getSearchhereTextbox().sendKeys(prodSearch);
		//driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("Micromax Canvas Mega 4G");
		h.getSearchButton().click();
		//driver.findElement(By.xpath("//button[@class='search-button']")).click();
		Thread.sleep(2000);
		//click on the product
		driver.findElement(By.xpath("//a[text()='"+prodSearch+"']")).click();
		Thread.sleep(2000);
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
