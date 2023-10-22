package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmiCalculatorTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(5000);
		String ele = driver.findElement(By.cssSelector("g:hover")).getText();
		System.out.println(ele + " from cursor");
		
		List<WebElement> allTooltip = driver.findElements(By.xpath("//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text' and @data-z-index='1']//*[name()='tspan']"));
		for (WebElement web : allTooltip) {
			String text = web.getText();
			System.out.println(text);
		}
	}
}
