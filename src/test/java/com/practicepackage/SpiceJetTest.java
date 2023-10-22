package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJetTest {
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.spicejet.com/");
		String Frommonth = "September";
		int fromyear = 2023;
		String Tomonth = "October";
		int Toyear = 2023;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1g40b8q']/div[1]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div[1]/div[2]/input")).click();
		driver.findElement(By.xpath("//div[text()='DEL']")).click();
		//driver.findElement(By.xpath("//div[text()='Departure Date']/../div[2]/div")).click();
		driver.findElement(By.xpath("//div[text()='"+Frommonth+" ' and text()='"+fromyear+"']/../../descendant::div[text()='12']")).click();
		driver.findElement(By.xpath("//div[text()='"+Tomonth+" ' and text()='"+Toyear+"']/../../descendant::div[text()='12']")).click();
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		driver.findElement(By.xpath("//div[text()='USD']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		
	}
}
