package exampleshasz;

import java.util.HashMap;
import java.util.Map;

//Using for each to iterate through a HashMap  - For each is available in Java versions 1.5
public class HaszMapExample2 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
