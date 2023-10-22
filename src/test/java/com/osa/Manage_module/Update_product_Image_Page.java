package com.osa.Manage_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Update_product_Image_Page {
	@FindBy(xpath="//button[text()='Update']")
	private WebElement UpdateBtn;

	public Update_product_Image_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUpdateBtn() {
		return UpdateBtn;
	}
	
	
}
