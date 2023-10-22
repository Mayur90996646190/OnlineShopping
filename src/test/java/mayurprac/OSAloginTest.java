package mayurprac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OSAloginTest {
//mvn -Durl=http://rmgtestingserver/domain/Online_Shopping_Application/ -Dusername1=anuj.lpu1@gmail.com -Dpassword1=Test@123 -DOSAloginTest test

	public static void main(String[] args) {
		// browser chrome
		// url http://rmgtestingserver/domain/Online_Shopping_Application/
		// username anuj.lpu1@gmail.com
		// password Test@123
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login as user
		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[4]/a")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("anuj.lpu1@gmail.com");
		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 sign-in']/descendant::input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
		
		
//		for (WebElement webElement : pnames) {
//			String text =webElement.getText();
//			System.out.println(text);
//		}
//		int count = 0;
//		for (int i=0;i<=15;i++) {
//			List<WebElement> pnames = driver.findElements(By.xpath("//div[@class='module']//tr[*]/td[2]"));
//			System.out.println(pnames.size());
//			try {
//				for (WebElement pn : pnames) {
//					String pname = pn.getText();
//					if (pname.contains("MI")) {
//						count++;
//						break;
//					}
//					System.out.println(pname);
//				}
//				throw new CustomE();
//			} catch (Exception e) {
//				driver.findElement(By.id("DataTables_Table_0_next")).click();
//			} 	
//		}
//		if (count > 0)
//		{
//			System.out.println("product is found");
//		}
//		else
//			System.out.println("product is not found");



	}

}
