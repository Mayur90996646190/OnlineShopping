package mayurprac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.osa.genericUtils.WebDriverUtility;

public class AmazonScroll {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebDriverUtility wLib  =new WebDriverUtility();
		WebElement element = driver.findElement(By.xpath("//span[text()='USD - U.S. Dollar']"));
		//wLib.scrollToPerticularElement(driver, element);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,500)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,document.body.Height)");
		Actions a = new Actions(driver);
		a.scrollToElement(element);
		
	}
}
