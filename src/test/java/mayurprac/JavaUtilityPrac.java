package mayurprac;


import java.util.Date;
import java.util.Random;

public class JavaUtilityPrac {
	public int getRandomNumber() {
		Random random = new Random();
		int r = random.nextInt(1000);
		return r;
	}
	
	public  String getDateInRequiredFormat() {
		Date dateAndTime = new Date();
		String[] d = dateAndTime.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year = d[5];
		String requredFormat = date+" "+month+" "+year+" "+day;
		return requredFormat;
	}
	
	
}
