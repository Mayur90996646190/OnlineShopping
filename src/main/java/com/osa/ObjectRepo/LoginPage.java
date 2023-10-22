package com.osa.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(name="email")
	private WebElement EmailAddTF;
	
	@FindBy(xpath="//div[@class='col-md-6 col-sm-6 sign-in']/descendant::input[@name='password']")
	private WebElement PasswordTF;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement LoginBt;
	
	@FindBy(xpath="//ul[@class='list-unstyled']/li[4]/a")
	private WebElement LoginLink;
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilazation
	public WebElement getEmailAddTF() {
		return EmailAddTF;
	}

	public WebElement getPasswordTF() {
		return PasswordTF;
	}

	public WebElement getLoginBt() {
		return LoginBt;
	}
	
	
	public WebElement getLoginLink() {
		return LoginLink;
	}

	public void LoginUser(String USERNAME,String PASSWORD)
	{
		EmailAddTF.sendKeys(USERNAME);
		PasswordTF.sendKeys(PASSWORD);
		LoginBt.click();
	}
	
}
