package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadiTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//span[text()='Standings']")).click();
		String teamName = "Puneri Paltan";
		String pos = driver.findElement(By.xpath("//p[text()='" + teamName
				+ "']/../../../../../../../div[*]//div[@class='table-data position']/button/following-sibling::p[1]"))
				.getText();
		System.out.println(pos + " is a position of " + teamName + "");
		String matchplayed = driver.findElement(By.xpath(
				"//p[text()='" + teamName + "']/../../../../../../../div[*]//div[@class='table-data matches-play']/p"))
				.getText();
		System.out.println(matchplayed + " are matchplayed of " + teamName + "");
		String won = driver.findElement(By.xpath(
				"//p[text()='" + teamName + "']/../../../../../../../div[*]//div[@class='table-data matches-won']/p"))
				.getText();
		System.out.println(won + " are no of won " + teamName + "");
		String lost = driver.findElement(By.xpath(
				"//p[text()='" + teamName + "']/../../../../../../../div[*]//div[@class='table-data matches-lost']/p"))
				.getText();
		System.out.println(lost + " are no of lost " + teamName + "");
		String draw = driver.findElement(By.xpath(
				"//p[text()='" + teamName + "']/../../../../../../../div[*]//div[@class='table-data matches-draw']/p"))
				.getText();
		System.out.println(draw + " are no of draw " + teamName + "");
		String scoreDiff = driver.findElement(By.xpath(
				"//p[text()='" + teamName + "']/../../../../../../../div[*]//div[@class='table-data score-diff']/p"))
				.getText();
		System.out.println(scoreDiff + " are no of score-diff " + teamName + "");
		String points = driver.findElement(By
				.xpath("//p[text()='" + teamName + "']/../../../../../../../div[*]//div[@class='table-data points']/p"))
				.getText();
		System.out.println(points + " are points of " + teamName + "");

	}
}
