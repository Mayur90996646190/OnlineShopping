package mayurprac;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRetryMayur extends BaseClassMayurPrac {
	@Test(retryAnalyzer = mayurprac.RetryImp1.class)
	public void mayurTest() {
		System.out.println("from retry");
		Assert.assertEquals("A", "B");
	}
}
