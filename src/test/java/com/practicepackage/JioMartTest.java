package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jiomart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement groceries = driver.findElement(By.xpath("//a[text()='Groceries']"));
		Actions a = new Actions(driver);
		a.moveToElement(groceries).perform();
		List<WebElement> gl = driver.findElements(By.xpath("//a[text()='Fruits & Vegetables']/../../li/a"));
		Thread.sleep(3000);
		
		WebElement txt1 = driver.findElement(By.cssSelector("a:hover"));
		String txt = txt1.getText();
		System.out.println(txt + " cursor");
		for (WebElement gE : gl) {
			String g1 = gE.getText();
			if (g1.equalsIgnoreCase(txt)) {
				////a[text()='Dairy']/../../li/a
				List<WebElement> fvEle = driver.findElements(By.xpath("//a[text()='" + g1 + "']/../../li/a"));
				for (WebElement web : fvEle) {
					String text = web.getText();
					System.out.println(text);
				}
			}
		}

	}
}
