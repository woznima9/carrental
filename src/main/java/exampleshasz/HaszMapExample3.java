package exampleshasz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Iterate through HashMap using Iterator
public class HaszMapExample3 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
