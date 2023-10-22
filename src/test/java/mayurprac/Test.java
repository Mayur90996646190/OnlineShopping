package mayurprac;

import java.util.HashMap;
import java.util.Map.Entry;


public class Test {
	public static void main(String[] args) {
		HashMap< String, String > map = new HashMap<String, String>() ;
		map.put("Mayur","Isampelliwar");
		map.put("Mahseh","Badkelwar");
		
//		System.out.println("From First loop");
//		for (Entry<String, String> s : map.entrySet()) {
//			System.out.println(s.getKey()+ " " +s.getValue());
//		}
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("sans", "Isampelliwar");
	//	System.out.println("From second loop");
//		for ( Entry<String, String> str: map.entrySet() ) {
//			System.out.println(str.getKey()+ " " +str.getValue());
//		}
		
		
		HashMap<String, HashMap<String, String>> nestedMap = new HashMap<>();
		nestedMap.put("Outer1",map);
		nestedMap.put("Outer2", map1);
		
		System.out.println(nestedMap.get("Outer1"));
		System.out.println(nestedMap.get("Outer2"));
		
	}
	
}
