package mayurprac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTCPrac {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ksrtc.in/");
		String month = "September";
		int date = 28;
		int year = 2023;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// date of departure
		driver.findElement(By.name("txtJourneyDate")).click();
		for (;;) {
			try {
				driver.findElement(By.xpath("//span[text()='" + month + "']/following-sibling::span[text()='" + year
						+ "']/ancestor::div[@id='ui-datepicker-div']/descendant::a[text()='" + date + "']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
		}
		 month = "October";
		 date = 10;
		 year = 2023;
		// date of Return
		 driver.findElement(By.name("txtReturnJourneyDate")).click();
		for (;;) {
			try {
				driver.findElement(By.xpath("//span[text()='" + month + "']/following-sibling::span[text()='" + year
						+ "']/ancestor::div[@id='ui-datepicker-div']/descendant::a[text()='" + date + "']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
		}
	//	driver.close();

	}
}
