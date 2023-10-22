package mayurprac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForEachTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/my-cart.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> pnames = driver.findElements(By.xpath("//th[.='my wishlist']/../../../tbody/tr[*]/td[2]/div/a"));
		int count = 0;	
		for (WebElement pn : pnames) {
			String pname = pn.getText();
			System.out.println(pname);
			if(pname.contains("MI"))
			{
				count++;
				break;
			}
		}
	}
}
