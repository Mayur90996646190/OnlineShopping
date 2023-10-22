package mayurprac;

public class Test1 {
	public static void main(String[] args) {
		int num =7;
		int i = 2;
		int count = 0;
		while(i<=num/2) {
			if(num%i==0) {
				count++;
				
			}
			i++;
		}
		if(count==0) {
			System.out.println(num + " is a prime no");
		}
	}
}
