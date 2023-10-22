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

public class IrctcLinkStatusCodePrac {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> listlinks = driver.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());
		ArrayList<String> ls = new ArrayList<>();
		for(int i=0; i<listlinks.size(); i++)
		{
			String eachlink=listlinks.get(i).getAttribute("href");
			URL url = null;
			int statusCode = 0;
			try {
				url = new URL(eachlink);
				HttpsURLConnection httpcon=(HttpsURLConnection)url.openConnection();
				statusCode=httpcon.getResponseCode();
				if(statusCode>=400)
				{
					System.out.println(eachlink +"=="+statusCode);
					ls.add(eachlink);
				}
			}
			catch(Exception e)
			{
				ls.add(eachlink);
			}
		}
	}
}
