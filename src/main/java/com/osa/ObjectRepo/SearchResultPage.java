package com.osa.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	@FindBy(xpath="//div[@class='product-info']/descendant::a[3]")
	private WebElement AddToCartBtn;
	
	@FindBy(xpath="//a[text()='Micromax Canvas Mega 4G']/ancestor::div[@class='product']/descendant::a[@title='Wishlist']")
	private WebElement wishListBtn;

	//intialization
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddToCartBtn() {
		return AddToCartBtn;
	}

	public WebElement getWishListBtn() {
		return wishListBtn;
	}
	
	
	
	
}
