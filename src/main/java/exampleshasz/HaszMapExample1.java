package exampleshasz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Iterate through HashMap with Lambda Expressions in Java 8
public class HaszMapExample1 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value2");
        map.put("key5", "value2");
        map.forEach((key, value) -> System.out.println(key + " = " + value));
        map.forEach((a, b) -> System.out.println(a + " = " + b));
        System.out.println("equals");
        map.forEach((a, b) -> System.out.println(a.equals("key3") + " = " + b));
        System.out.println("wyswietl wartosc pod zadanym kluczem");
        map.forEach((a, b) -> System.out.println(a.equals("key3") + " = " + b));
        List<Map.Entry> meKey = map.entrySet().stream().filter(a -> a.getKey().equals("key3")).collect(Collectors.toList());
        System.out.println(meKey);
        List<Map.Entry> meValue = map.entrySet().stream().filter(a -> a.getValue().equals("value2")).collect(Collectors.toList());
        System.out.println(meValue);
        List<String> meValue1 = map.entrySet().stream().filter(a -> a.getValue().equals("value2")).map(a -> a.getKey()).collect(Collectors.toCollection(() -> new ArrayList<String>()));
        System.out.println("Lista string kluczy" + meValue1);
        System.out.println("z listy moge zrobic geta " + meValue1.get(1));
        int score = (int) map.entrySet().stream().filter(entry -> entry.getKey().equals("key3")).count();
        System.out.println(score);
    }


}
