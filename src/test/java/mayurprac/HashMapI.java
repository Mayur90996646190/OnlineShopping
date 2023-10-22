package mayurprac;

import java.util.HashMap;
import java.util.Map;

public class HashMapI {
    public static void main(String[] args) {
        Map<String, Map<String, String>> nestedMap = new HashMap<>();

        // Create inner key-value pairs
        Map<String, String> innerMap1 = new HashMap<>();
        innerMap1.put("innerKey1", "innerValue1");
        innerMap1.put("innerKey2", "innerValue2");

        Map<String, String> innerMap2 = new HashMap<>();
        innerMap2.put("innerKey3", "innerValue3");
        innerMap2.put("innerKey4", "innerValue4");

        // Store the inner key-value pairs in the outer map
        nestedMap.put("outerKey1", innerMap1);
        nestedMap.put("outerKey2", innerMap2);

        // Retrieve values from the nested map
        System.out.println(nestedMap.get("outerKey1")); // Returns the inner map {innerKey1=innerValue1, innerKey2=innerValue2}
        System.out.println(nestedMap.get("outerKey2")); // Returns the inner map {innerKey3=innerValue3, innerKey4=innerValue4}

        // Retrieve values from the inner map
        System.out.println(nestedMap.get("outerKey1").get("innerKey1")); // Returns "innerValue1"
    }
}
