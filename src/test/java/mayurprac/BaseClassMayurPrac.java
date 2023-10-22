package mayurprac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClassMayurPrac {
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	//@Parameters("browser")
	@BeforeClass
	public void configBC() {
		String browser = "chrome";
		if(browser.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
			driver = new FirefoxDriver();
		sdriver = driver;
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Launch the browser");
		 
	}
	@BeforeMethod
	public void configBM() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		System.out.println("Login to the app");
	}
	@AfterMethod
	public void configAM() {
		driver.findElement(By.id("logoutLink")).click();
		System.out.println("logout from app");
	}
	
	@AfterClass
	public void configAC() {
		driver.close();
		System.out.println("close the browser");
	}
}
