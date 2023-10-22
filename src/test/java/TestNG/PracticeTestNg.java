package TestNG;

import org.testng.annotations.Test;

public class PracticeTestNg {
	
	@Test(invocationCount  = 0)
	public void createTest() {
		int[] a = {1,3,5};
		System.out.println(a[4]);
		System.out.println("created Test");
	}
	
	@Test(dependsOnMethods = "createTest")
	public void editTest() {
		System.out.println("Edit test");
	}
	
	@Test
	public void deleteTest() {
		System.out.println("Deleted Test");
	}
}
