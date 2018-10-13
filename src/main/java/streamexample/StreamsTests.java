package streamexample;

import carrentalapp.Car;
import carrentalapp.Cars;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTests {

    public static void main(String[] args) {
//        IntStream.of(1, 2, 3, 4, 5).forEach(e -> {
//            System.out.println(e * 2);
//        });
//        IntStream.of(1, 2, 3, 4, 5).forEach(e -> System.out.println(e + 1));
//        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::println);
//        Stream.of("one", "two", "three", "four\n").forEach(e -> System.out.println(e));
//        Stream.of("fife", "sex", "seven", "eight").forEach(System.out::println);
//
//        String[] swatches = new String[]{"Cisco", "Classic", "Swiss", "Wimbledon", "Ackulin", "Swiss"};
//
//        System.out.println("mam Tablicę stringów: "+ swatches);
//        System.out.println(Arrays.asList(swatches));
//        System.out.println(swatches[2]);
//        System.out.println("TABLICA o długości" +swatches.length);
//        Set<String> swatchesSet = new TreeSet<>();
//        for (String e : swatches) {
//            swatchesSet.add(e);
//        }
//        Comparator compareInAlphabeticalOrder = new AlphabeticalOrder();
//        Collections.sort(awatchesArrayList, compareInAlphabeticalOrder);
//        Collections.sort(awatchesArrayList, (s1, s2) -> s1.compareTo(s2));
//        awatchesArrayList.stream().sorted(compareInAlphabeticalOrder).map(e -> e + "jasio").forEach(System.out::print);
//
//        swatchesSet.stream().map(e->" ##"+e+"** ").forEach(System.out::print);
//        System.out.println("TREESET o długgości "+swatchesSet.size());
//
//        List<String> listaJasia = new LinkedList<>();
//        listaJasia.add("JasioDupa");
//        System.out.println("jstem przed");
////        awatchesArrayList.stream().sorted(compareInAlphabeticalOrder).map(e -> e + "JASIO").collect(Collectors.toList());
//        System.out.println("jestem za");
//        listaJasia.stream().forEach(System.out::println);


//        awatchesArrayList.sort(compareInAlphabeticalOrder);
//        System.out.println("posortowana lista" + awatchesArrayList);


//        Arrays.sort(swatches, compareInAlphabeticalOrder);
//        System.out.println(Arrays.asList(swatches));

        Integer[] score = new Integer[]{1, 4, 76, 6, 4, 11, 0};
        System.out.println(Arrays.asList(score));
        System.out.println(StreamsTests.myMethod(score[2]));
        Arrays.stream(score).map(e -> StreamsTests.myMethod(e)).forEach(System.out::println);

        Arrays.sort(score, Comparator.reverseOrder());
        System.out.println(Arrays.asList(score));

        Set<Integer> prices = new LinkedHashSet<>();
        prices.add(55);
        prices.add(1);
        prices.add(0);
        prices.add(-1);
        prices.add(8);
        prices.add(12);
        System.out.println(prices);
//        Collections.sort(prices,Comparator.naturalOrder());

        prices.stream().sorted().forEach(System.out::println);
// zrobić obiekty Car, dane pobrać z tabeli
        Motorcycles motors = new Motorcycles();

        List<String> colors = Arrays.asList("czerwony", "zielony", "pomarańczowy", "niebieski", "zielony", "bordowy");
        List<Integer> vins = Arrays.asList(1, 1, 1);

        Iterator<String> colorsIterator = colors.iterator();
        Iterator<Integer> vinsIterator = vins.iterator();
        List<Motorcycle> myWorkingList = new ArrayList<>();
        while (colorsIterator.hasNext() && vinsIterator.hasNext()) {
            myWorkingList.add(new Motorcycle(colorsIterator.next(), vinsIterator.next()));
        }
        while (vinsIterator.hasNext()) {
            myWorkingList.add(new Motorcycle(vinsIterator.next()));
        }
        while (colorsIterator.hasNext()) {
            myWorkingList.add(new Motorcycle(colorsIterator.next()));
        }

        motors.setMotorcyclesList(myWorkingList);
        motors.getMotorcyclesList().stream().forEach(System.out::println);
        System.out.println("wyszukanie zerowych");
        motors.getMotorcyclesList().stream().filter(o -> o.getVin() == 0).forEach(System.out::println);
        System.out.println("ale cały czas mam pełna listę");
        motors.getMotorcyclesList().stream().forEach(System.out::println);
        System.out.println("posortujpo kolorze");
        motors.getMotorcyclesList().stream().sorted(new SortMotorcyclesByColor()).forEach(System.out::println);
        System.out.println("posortowane normalnie");

//        myWorkingList=motors.getMotorcyclesList().stream().sorted().forEach(System.out::println);
        myWorkingList = motors.getMotorcyclesList().stream().sorted().collect(Collectors.toList());


        List<Motorcycle> motoColorsRevers = myWorkingList.stream().filter(m -> m.getVin() == 1).collect(Collectors.toList());
        System.out.println(motoColorsRevers);
        StringBuilder sb = new StringBuilder();
        List<String> colorsToReverse = new ArrayList();
        motoColorsRevers.stream().map(m -> m.getColor()).forEach(colorsToReverse::add);
        System.out.println(colorsToReverse);
        String test = "napis";
        sb.append(test).reverse();
        System.out.println(sb.toString());
        List<String> colorsReversed = new ArrayList<>();
        colorsToReverse.stream().map(s -> new StringBuilder(s).reverse().toString()).forEach(colorsReversed::add);
        System.out.println(colorsReversed);
        Iterator<Motorcycle> motorcycleIterator = motoColorsRevers.iterator();
        for (String s : colorsReversed) {
            motorcycleIterator.next().setColor(s);
        }

        System.out.println(motoColorsRevers);
        System.out.println(myWorkingList);


    }

    static String myMethod(int i) {
        String s = "napis";
        return s + 2 * i;
    }


}

class AlphabeticalOrder implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        return o2.compareTo(o1);
    }
}


class Motorcycle implements Comparable<Motorcycle> {
    private int vin;
    private String color;


    public Motorcycle(int vin) {
        this.vin = vin;
        color = "nieznany";
    }

    public Motorcycle(String color) {
        this.color = color;
        vin = 0;
    }

    public Motorcycle(String color, int vin) {
        this.color = color;
        this.vin = vin;
    }


    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void setColorStatic(String color) {
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "vin=" + vin +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Motorcycle o) {
        return this.getVin() - o.getVin();
    }
}

class Motorcycles {
    private List<Motorcycle> MotorcyclesList = new ArrayList<>();


    public List<Motorcycle> getMotorcyclesList() {
        return MotorcyclesList;
    }

    public void setMotorcyclesList(List<Motorcycle> motorcyclesList) {
        MotorcyclesList = motorcyclesList;
    }
}

class SortMotorcyclesByColor implements Comparator<Motorcycle> {
    @Override
    public int compare(Motorcycle o1, Motorcycle o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}
