package com.practicepackage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KayakTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("svg[class='vvTc-item-icon']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("Bangaluru");
		driver.findElement(By.xpath("//span[text()='Bengaluru, Karnataka, India']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//span[text()='New Delhi, National Capital Territory of India, India']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		String fmonthandyear = "October 2023";
		int fDate = 10;
		String tmonthandyear = "November 2023";
		int tDate = 16;
		driver.findElement(By.xpath("//div[text()='"+fmonthandyear+"']/../../descendant::div[text()='"+fDate+"']")).click();
		driver.findElement(By.xpath("//div[text()='"+tmonthandyear+"']/../..//div[text()='"+tDate+"']")).click();
		Actions a = new Actions(driver);
		a.scrollByAmount(0, -60).perform();
		driver.findElement(By.cssSelector("svg[class='c8LPF-icon']")).click();
		Thread.sleep(5000);
		Set<String> allwh=driver.getWindowHandles();
		for (String wh : allwh) {
			driver.switchTo().window(wh);
		}
	    //driver.findElement(By.xpath("//*[name()='svg' and @class='c8LPF-icon']")).click();
//	    Alert a1 = driver.switchTo().alert();
//		a1.dismiss();
//		Set<String> allwh=driver.getWindowHandles();
//		Thread.sleep(5000);
//		driver.switchTo().alert().accept();
		//driver.findElement(By.xpath("//div[@class='bBPb-close']/span")).click();
		driver.findElement(By.xpath("//div[@aria-label='Other sort']")).click();
		driver.findElement(By.id("depart_a")).click();
		driver.findElement(By.xpath("//div[@aria-label='Price' and @role = 'button']")).click();
		//driver.findElement(By.xpath("//span[@aria-valuenow='25000']")).click();
		
	}
}
