package com.osa.Manage_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelevisionSubCatePage {
	
	public WebElement getTelevisionImage() {
		return TelevisionImage;
	}


	@FindBy(xpath="//div[@class='product-image']")
	private WebElement TelevisionImage;	
	 	
	
	public TelevisionSubCatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
