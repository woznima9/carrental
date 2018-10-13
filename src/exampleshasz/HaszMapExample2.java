package exampleshasz;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Using for each to iterate through a HashMap  - For each is available in Java versions 1.5
public class HaszMapExample2 {

    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");
        myMap.put("key2", "valuex");  // .put() zastapila stara wartosc pod kluczem key2
        myMap.put("key3", "value3");
        myMap.put("key4", "value4");

        System.out.println("biore getem "+myMap.get("key3"));

        for (Map.Entry<String, String> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        myMap.entrySet().stream().forEach(System.out::println);
        System.out.println("myMap.values() "+myMap.values());
        System.out.println(myMap.values().size());
        System.out.println(myMap.values());
        Map<String, String> myInterator = myMap;
        System.out.println("just like this - myIterator"+myInterator);
        System.out.println("myIterator.entrySet() "+myInterator.entrySet());
        System.out.println("myIterator.keySet() "+myInterator.keySet());
        Set<String> somKeyValues= myInterator.keySet();
        Collection<String> somKeyValuesCollection=myInterator.keySet();
        System.out.println(somKeyValuesCollection.hashCode());

    }

}
