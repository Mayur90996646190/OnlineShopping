package mayurprac;

interface A
{
	public void test();
}
interface B
{
	public void test();
}
class I implements A,B
{
	public void test() {
		System.out.println("From test");
	}
}
public class Run {
	public static void main(String[] args) {
		I i =new I();
		B obj = (B)i;
		obj.test();
	}

}
