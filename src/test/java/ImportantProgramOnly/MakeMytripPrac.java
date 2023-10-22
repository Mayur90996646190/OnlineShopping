package ImportantProgramOnly;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMytripPrac {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		Actions a = new Actions(driver);
		String dmonth = "October";
		int ddate = 29;
		int dyear = 2023;
		a.scrollByAmount(0, 300).perform();
		//Departure
		driver.findElement(By.xpath("//div[contains(text(),'"+dmonth+"')]/ancestor::div[@class='DayPicker-Month']/descendant::div[@aria-disabled='false']/descendant::p[text()='"+ddate+"']")).click();
		
		//Return
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0,"+y+")");
		//js.executeScript("window.scrollTo(0,document.body.Height)");
		a.scrollByAmount(0,-500).perform();
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		String rmonth = "February";
		int rdate = 15;
		int ryear = 2024;
		
		WebElement nextMonth = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
		a.scrollByAmount(0,100).perform();
		for(;;)
		{
			try {
				
				//(//div[contains(text(),'February')]/span[text()='2024']/ancestor::div[@class='DayPicker-Months']/descendant::div[@aria-disabled='false']/descendant::p[text()='28'])[position()=2]
				driver.findElement(By.xpath("(//div[contains(text(),'"+rmonth+"')]/span[text()='"+ryear+"']/ancestor::div[@class='DayPicker-Months']/descendant::div[@aria-disabled='false']/descendant::p[text()='"+rdate+"'])[position()=2]")).click();
				break;
			}catch(Exception e)
			{
				
				nextMonth.click();
			}
		}
		
	}
}
