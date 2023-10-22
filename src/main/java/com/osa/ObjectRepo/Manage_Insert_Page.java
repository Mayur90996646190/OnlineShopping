package com.osa.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage_Insert_Page {
	
	@FindBy(xpath="//a[@href='manage-products.php']")
	private WebElement manage_products_Link;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTbx;
	
	public Manage_Insert_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getManage_products_Link() {
		return manage_products_Link;
	}

	public WebElement getSearchTbx() {
		return searchTbx;
	}
	
	
	
	
}
