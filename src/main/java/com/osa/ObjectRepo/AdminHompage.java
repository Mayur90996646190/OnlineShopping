package com.osa.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHompage {
	@FindBy(xpath="//a[@href='category.php']")
	private WebElement Create_CategoryLink;

	@FindBy(xpath="//a[@href='insert-product.php']")
	private WebElement insert_Product_link;
	
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement LogoutBtn;
	
	@FindBy(xpath="//a[@data-toggle='collapse' and @class='collapsed']")
	private WebElement OrderManagemntLink;
	
	@FindBy(xpath="//a[@href='pending-orders.php']")
	private WebElement PendingOrderLink;
	
//	@FindBy(xpath="//tr[@class='odd']/td[9]/a/i")
//	private WebElement updateOrderLink;

	@FindBy(xpath="//a[@href='manage-products.php']")
	private WebElement manageProductLink;
	
	@FindBy(xpath="//a[contains(text(),'Tele')]")
	private WebElement TelevisionLink;
	
	

	//initilization
	public AdminHompage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreate_CategoryLink() {
		return Create_CategoryLink;
	}
	public WebElement getInsert_Product_link() {
		return insert_Product_link;
	}
	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}

	public WebElement getOrderManagemntLink() {
		return OrderManagemntLink;
	}
	
	public WebElement getPendingOrderLink() {
		return PendingOrderLink;
	}

	public WebElement getManageProductLink() {
		return manageProductLink;
	}
	public WebElement getTelevisionLink() {
		return TelevisionLink;
	}
	
	
	

	
	
}
