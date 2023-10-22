package mayurprac;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class IRCTCStatusCodeTest{
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		ArrayList ls = new ArrayList();
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		URL url = null;
		int statusCode = 0;
		for (int i = 0; i <allLinks.size(); i++) {
			String eachlink=allLinks.get(i).getAttribute("href");
			try{
			url = new URL(eachlink);
			HttpsURLConnection httpcon=(HttpsURLConnection)url.openConnection();
			statusCode=httpcon.getResponseCode();
			if(statusCode>=400)
			{
				System.out.println(eachlink+" "+statusCode);
			}
			}
			catch (Exception e) {
				// TODO: handle exception
				ls.add(eachlink);
			}
		}
	}
}
