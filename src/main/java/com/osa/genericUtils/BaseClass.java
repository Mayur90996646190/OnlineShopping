package com.osa.genericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.osa.ObjectRepo.AdminHompage;
import com.osa.ObjectRepo.AdminLoginPage;

public class BaseClass {
	public  WebDriverUtility wLib = new WebDriverUtility();
	public  DatabaseUtility dLib = new DatabaseUtility();
	public  JAVAUtility jLib = new JAVAUtility();
	public  ExcelUtility eLib = new ExcelUtility();
	public  FileUtility fLib = new FileUtility();
	public  WebDriver driver;
	public  static WebDriver sdriver;
	
	@BeforeSuite(groups="smoke")
	public void configBS() throws SQLException {
		dLib.connectToDB();
		System.out.println("---connect to DB---");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups="smoke")
	public void configBC() throws IOException {
		
		String BROWSER  = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else
			driver = new InternetExplorerDriver();
		sdriver = driver;
		wLib.implicitWait(driver, 10);
		System.out.println("--launch the browser");
	}
	
//	@BeforeMethod
//	public void configBM() throws IOException {
//		
//		String URL = fLib.getPropertyKeyValue("url");
//		String USERNAME = fLib.getPropertyKeyValue("username");
//		String PASSWORD = fLib.getPropertyKeyValue("password");
//		driver.get(URL);
//		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[4]/a")).click();
//		LoginPage l = new LoginPage(driver);
//		l.LoginUser(USERNAME, PASSWORD);
//		System.out.println("login the application");
//	}
	//admin
	@BeforeMethod(groups="smoke")
	public void configBM() throws IOException {
		
		String ADURL = fLib.getPropertyKeyValue("adurl");
		String ADUSERNAME = fLib.getPropertyKeyValue("adusername");
		String ADPASSWORD = fLib.getPropertyKeyValue("adpassword");
		driver.get(ADURL);
		AdminLoginPage a = new AdminLoginPage(driver);
		a.LoginasAdmin(ADUSERNAME, ADPASSWORD);
		System.out.println("login the application");
	}

	@AfterMethod(groups="smoke")
	public void configAM() {
		AdminHompage ah = new AdminHompage(driver);
		ah.getLogoutBtn().click();
		System.out.println("Logout from application");
	}
	
	@AfterClass(groups="smoke")
	public void configAC() {
		driver.quit();
		System.out.println("close the browser");
	}
	
	@AfterSuite(groups="smoke")
	public void configAS() throws SQLException {
		dLib.closeDB();
		System.out.println("close the database");
	}
	
	
}
