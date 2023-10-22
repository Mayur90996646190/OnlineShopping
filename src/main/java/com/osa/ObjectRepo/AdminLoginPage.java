package com.osa.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(xpath="//input[@name='username']")
	private WebElement adusernameTbx;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement adPasswordTbx;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement adLoginBtn;
	
	//initialization
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getAdusernameTbx() {
		return adusernameTbx;
	}

	public WebElement getAdPasswordTbx() {
		return adPasswordTbx;
	}

	public WebElement getAdLoginBtn() {
		return adLoginBtn;
	}
	
	public void LoginasAdmin(String USERNAME,String PASSWORD)
	{
		adusernameTbx.sendKeys(USERNAME);
		adPasswordTbx.sendKeys(PASSWORD);
		adLoginBtn.click();
	}
	
	
}
