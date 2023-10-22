package TestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
	public void hardAssert() {
		System.out.println("step1");
		System.out.println("step2");
		assertEquals("A", "B", "expected B");
		System.out.println("step3");
		System.out.println("step4");
	}
	
	@Test
	public void hardAssert2() {
		System.out.println("step5");
		System.out.println("step6");
		assertNotEquals("A", "A");
		System.out.println("step7");
		System.out.println("step8");
	}
	
	@Test
	public void hardAssert3() {
		System.out.println("step9");
		int num = 50;
		assertNotNull(num);
		System.out.println("Step 10");
	}
	
	@Test
	public void hardAssert4() {
		System.out.println("Step 9");
		int num = 50;
		assertNull(num);
		System.out.println("Step 10");
	}
	
	@Test
	public void hardAssert5() {
		System.out.println("Step 11");
		int num = 50;
		assertNull(num);
		System.out.println("Step 12");
	}
	
	@Test
	public void hardAssert6() {
		System.out.println("step13");
		System.out.println("step14");
		assertSame("A", "B", "expected B");
		System.out.println("step15");
		System.out.println("step16");
	}
	@Test
	public void hardAssert7() {
		System.out.println("step17");
		System.out.println("step18");
		assertNotSame("A", "B", "expected B");
		System.out.println("step19");
		System.out.println("step20");
	}
}
