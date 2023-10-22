package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCTest1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> allText = driver.findElements(By.xpath("//span[text()='India']/../../../tr[*]/td[3][text()<40]"));
		System.out.println("Ranking of teams who are less than 40 are :");
		for (WebElement text : allText) {
			String t = text.getText();
			System.out.println(t);
		}
		System.out.println("no of counts of team have been played less than 40 rankings are : " +allText.size());
	}
}
