package com.osa.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateOrderPage {
	@FindBy(xpath="//select[@name='status']")
	private WebElement statusDD;
	
	@FindBy(xpath="//textarea[@name='remark']")
	private WebElement remarkTbx;
	
	@FindBy(xpath="//input[@name='submit2']")
	private WebElement updateBtn;
	
	public UpdateOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getStatusDD() {
		return statusDD;
	}

	public WebElement getRemarkTbx() {
		return remarkTbx;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	
}
