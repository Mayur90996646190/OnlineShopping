package com.practicepackage;


import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mysql.cj.xdevapi.JsonParser;
//"C:\Users\asus\eclipse-workspace\com.onlineshopping\src\test\resources\JSONFile.json"

public class JSONTest {
	public static void main(String[] args) throws Throwable {
		JSONParser p = new JSONParser();
		FileReader fr=new FileReader(".\\src\\test\\resources\\JSONFile.json");
		Object obj = p.parse(fr);
		JSONObject map = (JSONObject) obj;
		
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		
	}
}
