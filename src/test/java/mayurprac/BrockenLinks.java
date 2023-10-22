package mayurprac;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrockenLinks {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> allLink = driver.findElements(By.xpath("//a"));
		int count = allLink.size();
		ArrayList ls = new ArrayList();
		int count1 = 0;
		for (int i = 0; i <= 100; i++) {
			String eachlink = allLink.get(i).getAttribute("href");
			try {
				URL url = new URL(eachlink);
				HttpsURLConnection httpcon = (HttpsURLConnection) url.openConnection();
				int status = httpcon.getResponseCode();
				if (status >= 400) {

					System.out.println(eachlink);
				} else
				{
					ls.add(eachlink);
					count1++;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		System.out.println(ls + "  "+ count1);
	}
}
