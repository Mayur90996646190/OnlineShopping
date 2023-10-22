package com.practicepackage;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropetiesFileCreateTest {
	public static void main(String[] args) throws Throwable {
		Properties p = new Properties();
		p.setProperty("browser", "chrome");
		p.setProperty("url", "http://rmgtestingserver/domain/Online_Shopping_Application/");
		p.setProperty("username", "anuj.lpu1@gmail.com");
		p.setProperty("password", "Test@123");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/CommonDataCreate.properties");
		p.store(fos, "write data");
		fos.close();
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataCreate.properties");
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(PASSWORD);
		System.out.println(USERNAME);
		
	}
}
