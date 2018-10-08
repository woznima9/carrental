package exampleshasz;

import java.util.HashMap;
import java.util.Map;

// Iterate through HashMap with Lambda Expressions in Java 8
public class HaszMapExample1 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.forEach((key, value) -> System.out.println(key + " = " + value));
    }


}
