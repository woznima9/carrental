package setsexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MenuPositions {
    opcja_pierwsza("Opcja A", '1'),
    opcja_druga("Opcja B", '2'),
    opcja_trzecia("Opcja C", '3'),
    opcja_czwarta("Opcja D", '4'),
    opcja_piąta("Opcja E", '5');

    private static String optionDecription;
    private static char charKey;

    MenuPositions(String optionDecription, char charKey) {

    }


    public static String getOptionDecription() {
        return optionDecription;
    }

    public static char getCharKey() {
        return charKey;
    }

    static List<Character> getMenuChars() {
        List<Character> activeChars = new ArrayList<>();
        Arrays.stream(MenuPositions.values()).map(c -> getCharKey()).forEach(activeChars::add);
        return activeChars;
    }


}
