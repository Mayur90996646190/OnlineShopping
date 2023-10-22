package com.osa.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertProductPage {
	@FindBy(xpath="//select[@name='category']")
	private WebElement createCategoryDD;
	
	@FindBy(xpath="//select[@name='subcategory']")
	private WebElement sub_CategoryDD;
	
	@FindBy(xpath="//input[@name='productName']")
	private WebElement ProductNameTbx;
	
	@FindBy(xpath = "//input[@name='productCompany']")
	private WebElement ProductCompanyTbx;
	
	@FindBy(xpath="//input[@name='productpricebd']")
	private WebElement ProductPriceBDTbx;
	
	@FindBy(xpath="//input[@name='productprice']")
	private WebElement ProductPriceADTbx;
	
	@FindBy(xpath="//textarea[@name='productDescription']")
	private WebElement ProductDescriptionTbx;
	
	@FindBy(xpath="//input[@name='productShippingcharge']")
	private WebElement ProductDespTbx;
	
	@FindBy(xpath="//select[@name='productAvailability']")
	private WebElement productAvailabilityDD;
	
	@FindBy(xpath="//button[text()='Insert']")
	private WebElement InsertBtn;
	
	@FindBy(xpath="//input[@name='productimage1']")
	private WebElement productimage1Upload;
	
	@FindBy(xpath="//input[@name='productimage2']")
	private WebElement productimage2Upload;
	
	@FindBy(xpath="//input[@name='productimage3']")
	private WebElement productimage3Upload;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateBtn;
	
	
	//initialization
	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateCategoryDD() {
		return createCategoryDD;
	}

	public WebElement getSub_CategoryDD() {
		return sub_CategoryDD;
	}

	public WebElement getProductNameTbx() {
		return ProductNameTbx;
	}

	public WebElement getProductCompanyTbx() {
		return ProductCompanyTbx;
	}

	public WebElement getProductPriceBDTbx() {
		return ProductPriceBDTbx;
	}

	public WebElement getProductPriceADTbx() {
		return ProductPriceADTbx;
	}

	public WebElement getProductDescriptionTbx() {
		return ProductDescriptionTbx;
	}

	public WebElement getProductDespTbx() {
		return ProductDespTbx;
	}

	public WebElement getProductAvailabilityDD() {
		return productAvailabilityDD;
	}

	public WebElement getInsertBtn() {
		return InsertBtn;
	}

	

	public WebElement getProductimage1Upload() {
		return productimage1Upload;
	}

	public WebElement getProductimage2Upload() {
		return productimage2Upload;
	}

	public WebElement getProductimage3Upload() {
		return productimage3Upload;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
}
