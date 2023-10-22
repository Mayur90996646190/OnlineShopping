package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("phones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String phoneName = driver.findElement(By.xpath(
				"//i[@class='a-icon a-icon-checkbox']/preceding-sibling::input[@type='checkbox' and @checked]/../../../span"))
				.getText();
		List<WebElement> allRS = driver.findElements(By.xpath("//span[contains(text(),'" + phoneName
				+ "')]/ancestor::div[@class='sg-col-inner']//span[@class='a-price-whole'][number(translate(text(),'₹,',''))<30000]"));
		System.out.println("prices of phones");
		for (WebElement Rs : allRS) {
			System.out.println(Rs.getText());
		}

		List<WebElement> phonedetails = driver.findElements(By.xpath("//span[contains(text(),'" + phoneName
				+ "')]/ancestor::div[@class='sg-col-inner']//descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
		for (WebElement text : phonedetails) {
			String t = text.getText();
			System.out.println(t);
		}
	}
}
