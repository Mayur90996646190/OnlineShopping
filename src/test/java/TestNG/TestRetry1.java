package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;


import mayurprac.BaseClassMayurPrac;

public class TestRetry1 extends BaseClassMayurPrac {
	@Test(retryAnalyzer=TestNG.RetryImpclass.class)
	public void test1() {
		System.out.println("From test1");
		Assert.assertEquals(false, true);
	}
	@Test(retryAnalyzer=TestNG.RetryImpclass.class)
	public void test11() {
		System.out.println("From test11");
		Assert.assertEquals(false, true);
	}
}
