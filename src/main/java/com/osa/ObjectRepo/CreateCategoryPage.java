package com.osa.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {

	@FindBy(xpath="//button[text()='Create']")
	private WebElement createBtn;
	
	//initialization
	public CreateCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	//Business libraries
	public void createCategory(WebDriver driver,HashMap<String, String> map) {
		
		for(Entry<String, String> s : map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
	}

	
}
