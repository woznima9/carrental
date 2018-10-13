package exampleshasz;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
        mySet.add("Jasio");
        mySet.add("Daniel");
        mySet.add("Ania");
        mySet.add("Ania");
        mySet.add("Krzysio");
        System.out.println(mySet);
        System.out.println(mySet.size());
        TreeSet<String> myTreeSet = new TreeSet<>();
        myTreeSet.addAll(mySet);
        System.out.println(myTreeSet);
        Spliterator<String> myIter = myTreeSet.spliterator();

    }


}
