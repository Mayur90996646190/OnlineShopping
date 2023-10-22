package mayurprac;

import org.testng.annotations.Test;

public class Sample extends BaseClassMayurPrac{

	@Test(groups = {"smoke","regression"})
	public void testSample() {
		System.out.println("From Sample");
	}
}
