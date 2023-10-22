package com.osa.ProductpageandWishlist_Feature;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.osa.Manage_module.TelevisionSubCatePage;
import com.osa.ObjectRepo.AdminHompage;
import com.osa.ObjectRepo.HomePage;
import com.osa.ObjectRepo.LoginPage;
import com.osa.genericUtils.DatabaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JAVAUtility;
import com.osa.genericUtils.WebDriverUtility;

public class ProductpageandWishlist_FeatureTest2_POMTest {
	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties p = new Properties();
//		p.load(fis);
		DatabaseUtility dLib = new DatabaseUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JAVAUtility jLib = new JAVAUtility();
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL =fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD =fLib.getPropertyKeyValue("password");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wLib.implicitWait(driver, 10);
		//driver.manage().window().maximize();
		wLib.maximizeTheBrowser(driver);
		
		// Login as user
		//driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[4]/a")).click();
		LoginPage l = new LoginPage(driver);
		l.getLoginLink().click();
		
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 sign-in']/descendant::input[@name='password']"))
//				.sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[@name='login']")).click();
		l.LoginUser(USERNAME, PASSWORD);
		//Click on Electronics category in the homepage
		HomePage h = new HomePage(driver);
		h.getElectronicsMjTab().click();
		//driver.findElement(By.xpath("//a[text()=' Electronics']")).click();
		
		//Click on the Television subcategory
		TelevisionSubCatePage t = new TelevisionSubCatePage(driver);
	
		//driver.findElement(By.xpath("//a[contains(text(),'Television')]")).click();
		h.getTelvisionsubcatLink().click();
		
		//Click on the wishlist button
		//driver.findElement(By.xpath("//a[@title='Wishlist']")).click();
		h.getWishlistLink().click();
		
//		Alert a = driver.switchTo().alert();
//		a.accept();
		
		
		//Check that whether right product is added
		List<WebElement> pnames = driver.findElements(By.xpath("//th[.='my wishlist']/../../../tbody/tr[*]/td[2]/div/a"));
		int count = 0;	
		for (WebElement pn : pnames) {
			String pname = pn.getText();
		//	System.out.println(pname);
			if(pname.contains("MI"))
			{
				count++;
				break;
			}
		}
		if(count==1)
		{
			System.out.println("product is added");
		}
		else {
			System.out.println("Product is not added");
       }
		driver.close();

	}
}
