package com.osa.Order_Management_PO_Module;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.osa.ObjectRepo.AdminHompage;
import com.osa.ObjectRepo.AdminLoginPage;
import com.osa.ObjectRepo.UpdateOrderPage;
import com.osa.genericUtils.DatabaseUtility;
import com.osa.genericUtils.ExcelUtility;
import com.osa.genericUtils.FileUtility;
import com.osa.genericUtils.JAVAUtility;
import com.osa.genericUtils.WebDriverUtility;

public class Order_Management_PO_Module_POMTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		//		Properties p = new Properties();
		//		p.load(fis);
		DatabaseUtility dLib = new DatabaseUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		JAVAUtility jLib = new JAVAUtility();

		String BROWSER = fLib.getPropertyKeyValue("browser");
		String ADURL = fLib.getPropertyKeyValue("adurl");
		String ADUSERNAME = fLib.getPropertyKeyValue("adusername");
		String ADPASSWORD = fLib.getPropertyKeyValue("adpassword");

		WebDriver driver = new ChromeDriver();
		driver.get(ADURL);

		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wLib.implicitWait(driver, 10);

		//		driver.manage().window().maximize();
		wLib.maximizeTheBrowser(driver);

		// Login to the application with user the credentials
		//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ADUSERNAME);
		//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ADPASSWORD);
		//		driver.findElement(By.xpath("//button[@name='submit']")).click();
		AdminLoginPage al = new AdminLoginPage(driver);
		al.LoginasAdmin(ADUSERNAME, ADPASSWORD);

		// click on Order Management link
		// driver.findElement(By.xpath("//a[@data-toggle='collapse' and
		// @class='collapsed']")).click();
		AdminHompage ah = new AdminHompage(driver);
		ah.getOrderManagemntLink().click();

		// click on pending orders link
		// driver.findElement(By.xpath("//a[@href='pending-orders.php']")).click();
		ah.getPendingOrderLink().click();

		Thread.sleep(2000);
		// click on update order link
//		String srnum = "34";
//		for (;;) {
//			List<WebElement> ListsrNo = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']/td[1]"));
//			// System.out.println(ListsrNo);
//			try
//			{
//			for (WebElement web : ListsrNo) {
//				String srNo = web.getText();
//					if (srNo.contains(srnum)) {
//						driver.findElement(By.xpath("//tr[@class='odd' or @class='even']/td[9]/a/i")).click();
//						break;
//					}
//			}
//						WebElement ele = driver.findElement(By.xpath("//i[@class='icon-chevron-right shaded']"));
//						Actions act = new Actions(driver);
//						act.scrollToElement(ele).perform();
//						ele.click();
//			}
//			catch (Exception e) {
//				// TODO: handle exception
//			}
//
//
//		}

		String srnum = "34";
		for(;;)
		{
			try {
			driver.findElement(By.xpath("//tbody/tr/td[@class='  sorting_1' and text()='"+srnum+"']/following::td[8]//descendant::i[@class='icon-edit']")).click();
			break;
			}
			catch (Exception e) {
				WebElement ele = driver.findElement(By.xpath("//i[@class='icon-chevron-right shaded']"));
				Actions act = new Actions(driver);
				act.scrollToElement(ele).perform();
				ele.click();
			}

		}
		//		Set<String> allwh = driver.getWindowHandles();
		//		for (String wh : allwh) {
		//			
		//			driver.switchTo().window(wh);
		//			String url = driver.getCurrentUrl();
		//			if(url.contains("http://rmgtestingserver/domain/Online_Shopping_Application/admin/updateorder"))
		//			{
		//				break;
		//			}
		//			
		//		}
		wLib.switchTheWindowBasedOnURL(driver,"http://rmgtestingserver/domain/Online_Shopping_Application/admin/updateorder");

		//		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\OSA.xlsx");
		//		Workbook wb = WorkbookFactory.create(fi);
		//		Sheet sh =wb.getSheet("Order_management");
		//		String sdd = sh.getRow(1).getCell(0).getStringCellValue();
		String sdd = eLib.readDataFromExcelSheet("Order_management", 1, 0);

		// Enter all the details
		UpdateOrderPage up = new UpdateOrderPage(driver);
		//		WebElement status = driver.findElement(By.xpath("select[@name='status']"));
		WebElement status = up.getStatusDD();
		//		Select s = new Select(status);
		//		s.selectByVisibleText(sdd);
		wLib.selectDropDownByVisibleText(status, sdd);

		//		driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("delivered the pending product");
		up.getRemarkTbx().sendKeys("delivered the pending product");

		// driver.findElement(By.xpath("//input[@name='submit2']")).click();
		up.getUpdateBtn().click();

		Alert a = driver.switchTo().alert();
		//		a.accept();
		wLib.acceptAlertPopup(driver, a.getText());

		String text = driver.findElement(By.xpath("//form[@name='updateticket']/descendant::div")).getText();
		if (text.contains("Update Order")) {
			System.out.println("Order has been updated");
		} else
			System.out.println("Order has not been updated");
		driver.quit();
	}
}

