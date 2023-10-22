package mayurprac;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerImplementationPrac.class)
public class TestClass extends BaseClassMayurPrac {
	@Test
	public void test() {
		System.out.println("From execution of testMethod");
		Assert.assertEquals("A", "B");
	}
}
