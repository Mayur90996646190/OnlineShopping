package mayurprac;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int RandomNum() {
		Random ran = new Random();
		int random = ran.nextInt(100);
		return random;
	}
	public String dateFormat() {
		Date dateTime = new Date();
		String[] d =dateTime.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year = d[5];
		String dateFormat = day+" "+date+" "+month+" "+year;
		return dateFormat;
	}
	
}
