package com.osa.Order_Management_PO_Module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.osa.ObjectRepo.AdminHompage;
import com.osa.ObjectRepo.UpdateOrderPage;
import com.osa.genericUtils.BaseClass;

public class Order_Management_PO_Module_FromBaseClass extends BaseClass {
	@Test
	public void main() throws EncryptedDocumentException, IOException{
		//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		//		Properties p = new Properties();
		//		p.load(fis);
		

		

		

		// click on Order Management link
		// driver.findElement(By.xpath("//a[@data-toggle='collapse' and
		// @class='collapsed']")).click();
		AdminHompage ah = new AdminHompage(driver);
		ah.getOrderManagemntLink().click();

		// click on pending orders link
		// driver.findElement(By.xpath("//a[@href='pending-orders.php']")).click();
		ah.getPendingOrderLink().click();

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
		Assert.fail();
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

