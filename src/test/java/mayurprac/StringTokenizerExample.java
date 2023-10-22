package mayurprac;

import java.util.StringTokenizer;

import org.testng.annotations.Test;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String text = "apple,banana,cherry,date";
        StringTokenizer tokenizer = new StringTokenizer(text, ",");
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    }
    
    @Test
    public void token() {
    	String text = "Apple, banana,grapes,sapota,watermelon";
    	StringTokenizer tokenizer = new StringTokenizer(text, ",");
    	while(tokenizer.hasMoreTokens()) {
    		System.out.println(tokenizer.nextToken());
    	}
    }
    
    @Test
    public void tokenString() {
    	String text = "Apple, banana,grapes,sapota,watermelon";
    	String[] s = text.split(",");
    	
    	for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
    }
}

