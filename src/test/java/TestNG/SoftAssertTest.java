package TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void softAssert() {
		SoftAssert sa  = new SoftAssert();
		String expected="Shopping Portal Home Page1";
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actual = driver.getTitle();
		System.out.println(actual);
		sa.assertEquals(actual, expected);
		
		driver.close();
		sa.assertAll();
		
	}
	
//	@Test
//	public void softAssert1() {
//		SoftAssert sa  = new SoftAssert();
//		String expected="Shopping Portal Home Page";
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		String actual = driver.getTitle();
//		System.out.println(actual);
//		sa.assertEquals(actual, expected);
//		sa.assertAll();
//	}
}
