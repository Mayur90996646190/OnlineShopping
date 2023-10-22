package com.practicepackage;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraTest {
	public static void main(String[] args) throws SQLException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8084");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String expdata = "Tyss_onlineshoppingapplication1";
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[text()='Projects']")).click();
		 Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expdata);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mayur");
		WebElement drop = driver.findElement(By.xpath("//select[@name='status']"));
		Select s = new Select(drop);
		s.selectByVisibleText("Created");
		try {
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();
			System.out.println("project is added");
		}
		catch(Exception e)
		{
			System.out.println("project is not added");
		} 
			
		Connection con = null;
		Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query = "select * from project";
		ResultSet result = state.executeQuery(query);

		boolean flag = false;
		while (result.next()) {
			String actual = result.getString(4);
			if (actual.equalsIgnoreCase(expdata)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("data is matched");
		} else
			System.out.println("data is not mathed");

	}
}
