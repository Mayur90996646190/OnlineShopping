package mayurprac;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrockLinks {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		URL url = null;
		int status = 0;
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count = allLinks.size();
		ArrayList<String> ls = new ArrayList();

		for (int i = 0; i < count; i++) {

			try {
				String eachlink = allLinks.get(i).getAttribute("href");
				url = new URL(eachlink);
				HttpsURLConnection httpcon = (HttpsURLConnection) url.openConnection();
				status = httpcon.getResponseCode();
				if (status >= 400) {
					System.out.println(eachlink);
				} else {
					ls.add(eachlink);
				}
			}
			catch (Exception e) {
			}
		}
	}
}
