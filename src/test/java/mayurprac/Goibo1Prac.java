package mayurprac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibo1Prac {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		String dpmonthandyear = "September 2023";
		int dpdate = 28;
		//departure date
		driver.findElement(By.xpath("//span[@class='sc-12foipm-22 cUvQPq fswDownArrow']")).click();
		driver.findElement(By.xpath("//div[text()='"+dpmonthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+dpdate+"']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(2000);
		
		String remonthandyear = "October 2023";
		int redate = 28;
		//return date
		driver.findElement(By.xpath("//a[text()='Cancel']")).click();
		driver.findElement(By.xpath("//p[text()='Click to add a return flight for better discounts']")).click();
		driver.findElement(By.xpath("//div[text()='"+remonthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+redate+"']"));
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
	}
}
