package mayurprac;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

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
import com.osa.genericUtils.FileUtility;

public class WebDriverUtilityPrac {
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void implicitlyWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}

	public void elementTobeLocated(WebDriver driver, int duration, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void ignoringNoSuchElement(WebDriver driver, WebElement element, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}

	public void waitUntilUrlLoads(WebDriver driver, int duration, String expectedUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}

	public void waitUntilTitleLoads(WebDriver driver, int duration, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void customWait(WebDriver driver, WebElement element) throws InterruptedException {
		int count = 0;

		try {
			while (count <= 20) {
				element.click();
				break;
			}
		} catch (Exception e) {
			Thread.sleep(1000);
			count++;
		}

	}

	public void handleAlertPopup(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void switchToWindowBasedOnUrl(WebDriver driver, String expectedurl) {
		Set<String> allWh = driver.getWindowHandles();
		for (String wh : allWh) {
			driver.switchTo().window(wh);
			String url = driver.getCurrentUrl();
			if (url.contains(expectedurl)) {
				break;
			}
		}
	}

	public void switchToBasedOnTitle(WebDriver driver, String expTitle) {
		Set<String> allwh = driver.getWindowHandles();
		for (String wh : allwh) {
			driver.switchTo().window(wh);
			String title = driver.getTitle();
			if (title.contains(expTitle)) {
				break;
			}
		}
	}

	public void selectDropDownBasedOnIndex(WebDriver driver, WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void selectDropdownBasedOnValue(WebDriver driver, WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectDropdownBasedOnVisible(WebDriver driver, WebElement element, String VisibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(VisibleText);
	}

	public void srollToPerticularElement(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.scrollToElement(element).perform();
	}

	public void mouseHoverToElement(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public void rightClick(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}

	public void doubleClickOnelement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}

	public void handleDisableElement(WebDriver driver, WebElement element, String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("documents.findById('" + id + "').value ='" + value + "'");
	}

	public void scrollToElement(WebDriver driver, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(" + y + ")");
	}

	public void scrollToByAmount(WebDriver driver, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + y + ")");
	}

	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void clickOnEnterButton(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}

	public void switchToFrameByindex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void swichToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToBasedOnUrl1(WebDriver driver, String url) {
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> i = allwh.iterator();
		while (i.hasNext()) {
			String wh = i.next();
			driver.switchTo().window(wh);
			String URL = driver.getCurrentUrl();
			if (URL.contains(url)) {
				break;
			}

		}
	}
	public void pressEnter(WebDriver driver,WebElement element) throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	public void releaseKey(WebDriver driver, WebElement element) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public String takesScreenshot(WebDriver driver, String screenshot) {
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshot+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshot;
	}
	
	public String takesScreenshot(WebElement element, String screenshot) {
		TakesScreenshot t = (TakesScreenshot)element;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshot+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshot;
	}
	
	public void switchToBasedOnid(String id , WebDriver driver)
	{
		driver.switchTo().frame(id);
	}
	
	public void switchToBasedInElement(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}

}
