package com.osa.Manage_module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.osa.ObjectRepo.AdminHompage;
import com.osa.ObjectRepo.AdminLoginPage;
import com.osa.ObjectRepo.HomePage;
import com.osa.ObjectRepo.InsertProductPage;
import com.osa.ObjectRepo.LoginPage;
import com.osa.genericUtils.BaseClass;
import com.osa.genericUtils.DatabaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JAVAUtility;
import com.osa.genericUtils.WebDriverUtility;

public class Manage_Insert_Subcategory_Category_FromBaseClass extends BaseClass {
	@Test
	public void main() throws IOException {
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties p = new Properties();
//		p.load(fis);
		
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wLib.implicitWait(driver, 10);
		
		//driver.manage().window().maximize();
		wLib.maximizeTheBrowser(driver);

		
		AdminHompage ah = new AdminHompage(driver);
		//Click on the manage products link
		//driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		ah.getManageProductLink().click();
		
		String productName = "MI 80cm (32 Inches)";
		//See the product on the manage product page and search using horizintal next and previous button
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys("MI");
		driver.findElement(By.xpath("//td[text()='"+productName+"']/ancestor::tr[@class='even']/td[7]/a")).click();
		
		//Click on the Edit icon in Action table of perticular product to Edit the details or manage the product
		driver.findElement(By.xpath("//form[@class='form-horizontal row-fluid']/div[12]/descendant::a[text()='Change Image']")).click();
		
		//Click on the Product image 3 change image button
		//driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys("C:\\SS of Onlineshoapp\\Televison2.jpg");
		InsertProductPage i = new InsertProductPage(driver);
		i.getProductimage3Upload().sendKeys("C:\\SS of Onlineshoapp\\Televison2.jpg");
		
		//click on Update button
		//driver.findElement(By.xpath("//button[text()='Update']")).click();
		 i.getUpdateBtn().click();
		
		String conmsg=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		if(conmsg.contains("Product Image Updated"))
		{
			System.out.println("Product image is successfully updated from admin");
		}
		else
			System.out.println("Product image is not successfully updated from admin");
		
		//logout
		driver.findElement(By.xpath("//div[@class='sidebar']/ul[3]/li[2]/a")).click();
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		//login as user
		driver.get(URL);
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wLib.implicitWait(driver, 10);
		
		
		// Login as user
		//driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[4]/a")).click();
		LoginPage l = new LoginPage(driver);
		l.getLoginLink().click();
		
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 sign-in']/descendant::input[@name='password']"))
//				.sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		l.LoginUser(USERNAME, PASSWORD);
		//Assert.fail();
		
		//Click on the Electronics Category 
		//driver.findElement(By.xpath("//a[text()=' Electronics']")).click();
		HomePage h = new HomePage(driver);
		h.getElectronicsMjTab().click();
		
		
		//Click on the Television SubCategory 
		//driver.findElement(By.xpath("//a[contains(text(),'Tele')]")).click();
		ah.getTelevisionLink().click();
		
		//Check the images has been present
		//driver.findElement(By.xpath("//div[@class='product-image']")).click();
		TelevisionSubCatePage t = new TelevisionSubCatePage(driver);
		t.getTelevisionImage().click();
		
		
		//validate the image
		WebElement attrpath= driver.findElement(By.xpath("//img[@src='admin/productimages/226/Televison2.jpg']"));
		String att=attrpath.getAttribute("src");
		
		if(att.contains("Televison2"))
		{
			System.out.println("Image is presnt in user login");
		}
		else
			System.out.println("Image is not present in user login");
		
	}
}
