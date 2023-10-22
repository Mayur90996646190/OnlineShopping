package com.osa.Manage_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class CustomE extends RuntimeException {

}

public class Manage_Insert_Subcategory_Category_Test {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String ADURL = p.getProperty("adurl");
		String ADUSERNAME = p.getProperty("adusername");
		String ADPASSWORD =p.getProperty("adpassword");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Enter the username and password
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ADUSERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ADPASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		//Click on the manage products link
		driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		
		//See the product on the manage product page and search using horizintal next and previous button
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys("MI");
		driver.findElement(By.xpath("//td[text()='MI 80cm (32 Inches)']/ancestor::tr[@class='even']/td[7]/a")).click();
		
		//Click on the Edit icon in Action table of perticular product to Edit the details or manage the product
		driver.findElement(By.xpath("//form[@class='form-horizontal row-fluid']/div[12]/descendant::a[text()='Change Image']")).click();
		
		//Click on the Product image 3 change image button
		driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys("C:\\SS of Onlineshoapp\\Televison2.jpg");
		
		//click on Update button
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		String conmsg=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		if(conmsg.contains("Product Image Updated"))
		{
			System.out.println("Product image is successfully updated from admin");
		}
		else
			System.out.println("Product image is not successfully updated from admin");
		
		driver.findElement(By.xpath("//div[@class='sidebar']/ul[3]/li[2]/a")).click();
		
		
		//login as user
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		// Login as user
		driver.findElement(By.xpath("//ul[@class='list-unstyled']/li[4]/a")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("anuj.lpu1@gmail.com");
		driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 sign-in']/descendant::input[@name='password']"))
				.sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		//Click on the Electronics Category 
		driver.findElement(By.xpath("//a[text()=' Electronics']")).click();
		
		//Click on the Television SubCategory 
		driver.findElement(By.xpath("//a[contains(text(),'Tele')]")).click();
		
		//Check the images has been present
		driver.findElement(By.xpath("//div[@class='product-image']")).click();
		
		//validate the image
		WebElement attrpath= driver.findElement(By.xpath("//img[@src='admin/productimages/226/Televison2.jpg']"));
		String att=attrpath.getAttribute("src");
		
		if(att.contains("Televison2"))
		{
			System.out.println("Image is presnt in user login");
		}
		else
			System.out.println("Image is not present in user login");
		driver.quit();
	}
}
