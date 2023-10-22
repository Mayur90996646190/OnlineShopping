package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonXpathTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 14 pro max");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		List<WebElement> alltext = driver.findElements(By.xpath("//span[text()='Apple iPhone 14 Pro Max (256 GB) - Deep Purple']/../../../../descendant::span[@class='a-price-whole']"));
		for (int j = 0; j < alltext.size(); j++) {
			String text = alltext.get(j).getText();
			
				System.out.println(text);
			
		}

	}
}
