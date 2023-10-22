package mayurprac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
//driver.switchTo().newWindow(WindowType.WINDOW);
// driver.get("https://www.kayak.co.in/");
public class kayakXpathPrac {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[text()='See all']")).click();
		driver.manage().window().maximize();
		List<WebElement> allList = driver.findElements(
				By.xpath("//div[@id='ppTb-gridViewContainer']/descendant::div[@class='_ib0 _18 _igh _ial _iaj']"));
		for (WebElement al : allList) {
			String text = al.getText();
			System.out.println(text);
		}
	}
}
