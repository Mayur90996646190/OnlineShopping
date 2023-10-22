package com.osa.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration
	@FindBy(xpath = "//a[@href='my-account.php']")
	private WebElement myAcountLink;
	
	@FindBy(xpath ="//a[@href='my-wishlist.php']")
	private WebElement wishlistLink;
	
	@FindBy(xpath="//a[@href='my-cart.php']")
	private WebElement myCartLink;
	
	@FindBy(xpath="//a[@href='login.php']")
	private WebElement loginLink;
	
	@FindBy(xpath="//span[text()='Track Order']")
	private WebElement TrackOrderButton;
	
	@FindBy(xpath="//input[@class='search-field']")
	private WebElement SearchhereTextbox;
	
	@FindBy(xpath="//div[@class='basket']")
	private WebElement cartIconButton;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement HomeMjTab;
	
	@FindBy(xpath="//a[text()=' Electronics']")
	private WebElement ElectronicsMjTab;
	
	@FindBy(xpath="//a[text()=' Fashion 888']")
	private WebElement Fashion888MjTab;
	
	@FindBy(xpath="//a[text()=' Fashion 89']")
	private WebElement Fashion89MjTab;
	
	@FindBy(xpath="//a[text()=' Fashion 909']")
	private WebElement Fashion909MjTab;
	
	@FindBy(xpath="//a[text()=' Fashion 107']")
	private WebElement Fashion107MjTab;
	
	@FindBy(xpath="//a[text()=' Fashion 390']")
	private WebElement Fashion390Mjtab;
	
	@FindBy(className = "search-button")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[contains(text(),'Television')]")
	private WebElement TelvisionsubcatLink;
	
	
	
	

	public WebElement getTelvisionsubcatLink() {
		return TelvisionsubcatLink;
	}

	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getMyAcountLink() {
		return myAcountLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getMyCartLink() {
		return myCartLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getTrackOrderButton() {
		return TrackOrderButton;
	}

	public WebElement getSearchhereTextbox() {
		return SearchhereTextbox;
	}

	public WebElement getCartIconButton() {
		return cartIconButton;
	}

	public WebElement getHomeMjTab() {
		return HomeMjTab;
	}

	public WebElement getElectronicsMjTab() {
		return ElectronicsMjTab;
	}

	public WebElement getFashion888MjTab() {
		return Fashion888MjTab;
	}

	public WebElement getFashion89MjTab() {
		return Fashion89MjTab;
	}

	public WebElement getFashion909MjTab() {
		return Fashion909MjTab;
	}

	public WebElement getFashion107MjTab() {
		return Fashion107MjTab;
	}

	public WebElement getFashion390Mjtab() {
		return Fashion390Mjtab;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	
	
	
	
	
}
