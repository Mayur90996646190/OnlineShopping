package mayurprac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoiboPrac {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		driver.findElement(By.xpath("//span[@class='sc-12foipm-22 oSYrJ fswDownArrow']")).click();
		String monthYear = "September 2023";
		int date = 14;
		String actual = "//div[text()='" + monthYear + "']/../../descendant::p[text()='" + date + "']";
		String nextArrow = "//span[@aria-label='Next Month']";
		for (;;) {
			try {
				driver.findElement(By.xpath(actual)).click();
				break;

			} catch (Exception e) {
				driver.findElement(By.xpath(nextArrow)).click();
			}
		}
		//driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.manage().window().maximize();
		System.out.println("second");
		driver.findElement(By.xpath("//p[text()='Click to add a return flight for better discounts']")).click();
		String monthYear1 = "November 2023";
		int date1 = 20;
		String actual1 = "//div[text()='" + monthYear1 + "']/../../descendant::p[text()=" + date1 + "]";
		String nextArrow1 = "//span[@aria-label='Next Month']";
		for (;;) {
			try {
				driver.findElement(By.xpath(actual1)).click();
				break;

			} catch (Exception e) {
				driver.findElement(By.xpath(nextArrow1)).click();
			}
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();

	}
}
