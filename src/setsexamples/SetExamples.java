package setsexamples;

import java.util.*;


public class SetExamples {
    public static void main(String[] args) {
        KeyboardService keyboard = new KeyboardService();
        SetClas dictionary = new SetClas();
        SetExamples.showMenuPositions();
        boolean askAgain = true;
//        do switch (MenuPositions.getCharKey()) {
//            case opcja_pierwsza:
//                System.out.println("A");
//
//                break;
//
//
//        } while (askAgain);

        System.out.println("whole dict list");
        dictionary.showDictionary();

    }

    static void showMenuPositions() {
        for (MenuPositions m : MenuPositions.values()) {
            System.out.println(m + " " + m.getOptionDecription());
        }
    }


}

class SetClas {
    private Set<String> words = new HashSet<>();

    Set<String> getWordsSet() {
        words.add("Jasio");
        words.add("Zbysio");
        return words;
    }

    void storeWordIntoDictionary(String word) {
        words.add(word);
    }

    void showDictionary() {
        words.stream().forEach(System.out::println);
    }

    long wordsCount() {
        return words.stream().count();

    }

}