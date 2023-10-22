package mayurprac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PropertiesFileCreate {
	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis  = new FileInputStream(".\\src\\test\\java\\mayurprac\\createcommondata.properties");
		Properties p = new Properties();
		p.load(fis);
		p.setProperty("url", "http://rmgtestingserver/domain/online_shopping_application");
		p.setProperty("username", "anuj.lpu1@gmail.com");
		p.setProperty("password", "Test@123");
		p.setProperty("broswer", "chrome");
		FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\java\\\\mayurprac\\\\createcommondata.properties");
		p.store(fos, "write data");
		
		FileInputStream fi = new FileInputStream(".\\\\src\\\\test\\\\java\\\\mayurprac\\\\createcommondata.properties");
		p.load(fi);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(URL);
		System.out.println(PASSWORD);
	}
}
