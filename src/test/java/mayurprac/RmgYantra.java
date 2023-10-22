package mayurprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantra {
	public static void main(String[] args) throws SQLException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8084");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String expdata = "OSA MA";
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expdata);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("mayur");
		WebElement drop	 = driver.findElement(By.xpath("//select[@name='status']"));
		Select s = new Select(drop);
		s.selectByVisibleText("Created");
		try {
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();
			System.out.println("project is created");
		}
		catch(Exception e)
		{
			System.out.println("project is not created");
		}
		Connection con = null;
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state = con.createStatement();
		String query = "select * from project";
		ResultSet result = state.executeQuery(query);
		boolean flag =false;
		while(result.next())
		{
			String actual = result.getString(4);
			if(actual.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}

		}
		if(flag)
		{
			System.out.println("Project is created is present at database");
		}
		else
			System.out.println("Project is not created is not present at database");
		
	}
}
