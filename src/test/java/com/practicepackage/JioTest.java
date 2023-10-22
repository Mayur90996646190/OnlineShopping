package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JioTest {
	
	public static void test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jiomart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement groceries = driver.findElement(By.xpath("//a[text()='Groceries']"));
		Actions a = new Actions(driver);
		a.moveToElement(groceries).perform();
		
		Thread.sleep(5000);
		String ele = driver.findElement(By.cssSelector("a:hover")).getText();
		//System.out.println(ele + " from cursor");
		
		List<WebElement> list = driver.findElements(By.xpath("//a[text()='"+ele+"']/ancestor::li[@class='header-nav-l2-item']/descendant::a"));
		Thread.sleep(3000);
		
		for (WebElement web : list) {
			String txt = web.getText();
			System.out.println(txt);
		}
		
	}
}
