package com.osa.genericUtils;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class Contains all the driver methods
 * 
 * @author Mayur
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize the browser
	 * 
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This is wait until the element in the page gets load
	 * 
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}

	/**
	 * This method is wait until the url of page gets loads
	 * 
	 * @param driver
	 * @param duration
	 * @param expextedUrl
	 */
	public void waitUntilUrlLoads(WebDriver driver, int duration, String expectedUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}

	/**
	 * This method is used to wait until the title of the page is loads
	 * 
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilTitleLoads(WebDriver driver, int duration, String expectedTitle) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		
	}

	/**
	 * This method is used for wait until the element gets load
	 * 
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntiltheElementisClikable(WebDriver driver, int duration, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used for ignoring the NoSuchElementException And continue the
	 * Execution
	 * 
	 * @param driver
	 * @param duration
	 */
	public void ignoringNosuchElementException(WebDriver driver, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}

	/**
	 * This is used for until the element is visible in the page
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This method is used for select the dropdown based on the index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDownByindex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used for Select the dropdown by value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDownByValue(WebElement element, String value) {
		Select sel1 = new Select(element);
		sel1.selectByValue(value);

	}

	/**
	 * This method is used for select the dropdown by visibleText
	 * 
	 * @param element
	 * @param visibleText
	 */
	public void selectDropDownByVisibleText(WebElement element, String visibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to MouseOverOntheElement
	 * 
	 * @param element
	 * @param driver
	 */
	public void mouseOverOnTheElement(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used for Right click on the element
	 * 
	 * @param element
	 * @param driver
	 */
	public void rightClick(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * this method is used for click on the Enter button
	 * 
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method is used to switch to frame based on the index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to frame based on the id
	 * 
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * This method is used to Switch to the frame based on the WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch to the main Frame
	 * 
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to accept the alert popup
	 * 
	 * @param driver
	 * @param expectMsg
	 */
	public void acceptAlertPopup(WebDriver driver, String expectMsg) {
		Alert a = driver.switchTo().alert();
		if (a.getText().contains(expectMsg)) {
			System.out.println("Alert msg is varified");
		} else
			System.out.println("Alert msg is not verified");

		a.accept();
	}

	/**
	 * This method is used for dismiss the alert popup
	 * 
	 * @param driver
	 * @param expectMsg
	 */
	public void dismissAlertPopup(WebDriver driver, String expectMsg) {
		Alert a = driver.switchTo().alert();
		if (a.getText().equalsIgnoreCase(expectMsg)) {
			System.out.println("Alert msg is verified");
		} else
			System.out.println("Alert msg is not verified");
		a.dismiss();

	}

	/**
	 * This method is used to switch based on the title
	 * 
	 * @param driver
	 * @param expectMsg
	 */
	public void switchToBasedOnTitle(WebDriver driver, String expectTiltle) {
		Set<String> allwh = driver.getWindowHandles();
		for (String str : allwh) {
			driver.switchTo().window(str);
			String title = driver.getTitle();
			if (title.contains(expectTiltle)) {
				break;
			}
		}
	}
	
	/**
	 * This method used for switch to window based on the url
	 * @param driver
	 * @param expectedUrl
	 */
	public void switchTheWindowBasedOnURL(WebDriver driver,String expectedUrl) {
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it = allwh.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedUrl))
			{
				break;
			}
		}
		
	}
	
	/**
	 * This method is used to takescreenshot of webPage
	 * @param driver
	 * @param screenshotName
	 * @return
	 */
	public static String takeScreenShot(WebDriver driver,String screenshotName) {
		TakesScreenshot t = (TakesScreenshot)driver;
		String path = "./Screenshot/"+screenshotName+".png";
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest= new File("./Screenshot/"+screenshotName+".png");
		try {
			Files.copy(src, dest);
			//FileUtils.copyFile(src, dest); //present in the appache common io package
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * This method is used to takescreenshpt of element
	 * @param driver
	 * @param screenshotName
	 * @return
	 */
	public String takeScreenShotOfWebElement(WebElement element,String screenshotName) {
		TakesScreenshot t = (TakesScreenshot)element;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest= new File("./Screenshot/"+screenshotName+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotName;
	}
	
	/**
	 * This method is used to scroll to perticular element
	 * @param driver
	 * @param element
	 */
	public void scrollToPerticularElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	/**
	 * This method is used for press Enter button
	 * @param driver
	 * @throws AWTException
	 */
	public void enterKey(WebDriver driver) throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws AWTException
	 */
	public void enterRelease(WebDriver driver) throws AWTException
	{
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to draganddrop
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	
	/**
	 * This method is used to doubleclick on the webpage
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public void scrollTo(WebDriver driver, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+y+")");
	}
	
}
