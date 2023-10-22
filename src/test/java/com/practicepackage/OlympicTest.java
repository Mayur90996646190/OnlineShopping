package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String country = "Armenia";
		String gold = driver.findElement(By.xpath("//span[text()='" + country
				+ "']/../../../../div[1]/div[3]/div[@data-medal-id='gold-medals-row-1']/span/span")).getText();
		System.out.println(gold + " no of gold " + country + "");
		String silver = driver
				.findElement(By.xpath("//span[text()='" + country
						+ "']/../../../../div[1]/div[3]/div[@data-medal-id='silver-medals-row-1']/span/span"))
				.getText();
		System.out.println(silver + " no of silver " + country + "");
		String bronze = driver
				.findElement(By.xpath("//span[text()='" + country
						+ "']/../../../../div[1]/div[3]/div[@data-medal-id='bronze-medals-row-1']/span/span"))
				.getText();
		System.out.println(bronze + " no of bronze");
		String total = driver.findElement(By.xpath("//span[text()='" + country
				+ "']/../../../../div[1]/div[3]/div[@data-medal-id='total-medals-row-1']/span/span")).getText();
		System.out.println(total + " total no of medals " + country + "");
	}
}
