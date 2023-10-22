package TestNG;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class ExecutionOfAnnotations {

	@Test
	public void test2() {
		System.out.println("Testscript 2");
	}
	@Test
	public void test() {
		System.out.println("Testscript 1");
	}

	@BeforeSuite
	public void configBS() {
		System.out.println("connect to DB");
	}

	@BeforeClass
	public void configBC() {
		System.out.println("Launch the browser");
	}

	@BeforeMethod
	public void configBM() {
		System.out.println("Login the application");
	}

	@AfterMethod
	public void configAM() {
		System.out.println("logout the application");
	}

	@AfterClass
	public void configAC() {
		System.out.println("close the browser");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("Disconnect to DB");
	}
//	@BeforeClass
//	public void BC() {
//		System.out.println("From BC");
//	}
}
class Guarav{
	@Test
	public void gaurav() {
		System.out.println("from gaurav");
	}
}
