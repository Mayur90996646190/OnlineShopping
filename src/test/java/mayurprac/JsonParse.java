package mayurprac;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParse {
	public static void main(String[] args) throws Throwable, ParseException {
		JSONParser p = new JSONParser();
		FileReader fr = new FileReader(".\\src\\test\\resources\\JsonFile.json");
		Object obj =p.parse(fr);
		JSONObject map = (JSONObject) obj;
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("browser"));
	}
}
