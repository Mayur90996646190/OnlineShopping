package mayurprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class AmazonJDBCTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.findElement(By.name("field-keywords")).sendKeys("iphone 12");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> plist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		Connection con = null;
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Amazon","root","root");
		Statement state=con.createStatement();
		String query = "select * from plist1;";
		ResultSet result = state.executeQuery(query);
		
		int count=0;
		for (WebElement web: plist) {
			String pName = web.getText();
			while(result.next()) {
				if(result.getString("pName").contains(pName))
				{
					
				}else
				{
					
				}
			}
			state.executeUpdate("insert into plist1 values('"+pName+"','apple','apple',1)");
			System.out.println("Product Added =" + pName);
		}
		
		
	}
}
