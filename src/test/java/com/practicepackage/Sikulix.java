package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sikulix {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("pickfiles")).click();
//		Screen s = new Screen();
//		Pattern fileName = new Pattern("C:\\Users\\asus\\eclipse-workspace\\com.onlineshopping\\FileName.png");
//		String path = "C:\\SS of Onlineshoapp\\xpath.docx";
//		s.type(fileName,path);
	}
}
