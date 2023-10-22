package com.osa.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateOrderInfoPage {
	public void updateInfo(WebDriver driver) {
		String text = driver.findElement(By.xpath("//form[@name='updateticket']/descendant::div")).getText();
		if (text.contains("Update Order")) {
			System.out.println("Order has been updated");
		} else
			System.out.println("Order has not been updated");
	}
}
