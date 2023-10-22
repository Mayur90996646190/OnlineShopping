package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.osa.genericUtils.BaseClass;

import mayurprac.BaseClassMayurPrac;

public class TestRetry2 extends BaseClassMayurPrac {
	@Test(retryAnalyzer = TestNG.RetryImpclass.class)
	public void test2() {
		System.out.println("from test2");
		Assert.assertEquals(false, true);
	}
	@Test(retryAnalyzer = TestNG.RetryImpclass.class)
	public void test22() {
		System.out.println("from test22");
		Assert.assertEquals(false, true);
	}
}
