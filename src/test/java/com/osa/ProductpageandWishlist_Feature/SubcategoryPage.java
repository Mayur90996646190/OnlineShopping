package com.osa.ProductpageandWishlist_Feature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubcategoryPage {
	@FindBy(xpath="//a[@title='Wishlist']")
	private WebElement wishlistIconBtn;
	
	public SubcategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getWishlistIconBtn() {
		return wishlistIconBtn;
	}
	
	
}
