package mayurprac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookMvnCommanLineTest {
	@Test
	public void facebook() {
		WebDriver driver = new ChromeDriver();
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD =System.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
}
