package com.practicepackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class TextCaptcha2 {
	public static void main(String[] args) throws Throwable {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='h_menu_drop_button hidden-xs']")).click();
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		WebElement captcha = driver.findElement(By.xpath("//img[@class='captcha-img']"));
		File src = captcha.getScreenshotAs(OutputType.FILE);
		String path = "C:\\\\Users\\\\asus\\\\eclipse-workspace\\\\com.onlineshopping\\\\Screenshot\\\\captcha2.png";
		FileHandler.copy(src, new File(path));
		
		ITesseract ts = new Tesseract();
		ts.setDatapath("C:\\\\Users\\\\asus\\\\Downloads\\\\Tess4J-3.4.8-src\\\\Tess4J\\\\tessdata");
		String captchtext = ts.doOCR(new File(path));
		String actualtext = captchtext.toString().trim().replace(" ", "");
		System.out.println(actualtext);
	}
}
