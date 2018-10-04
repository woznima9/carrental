package carrentalapp;

import java.util.Scanner;

public class KeyReader {
    private String key;
    private String text;
    Scanner scanner = new Scanner(System.in);

    String getKey() {

        boolean letterIsNotCorrect;
        do {
            key = scanner.next().substring(0, 1);
            if (Options.getActiveKeysForOptions().contains(key)) {
                letterIsNotCorrect = false;
            } else {
                System.out.println("wybierz aktywną literkę z ponizszych dostępnych");
                System.out.println(Options.getActiveKeysForOptions());
                letterIsNotCorrect = true;
            }
        }
        while (letterIsNotCorrect);
        return key;
    }

    String getText() {
        text = scanner.nextLine();
        return text;
    }


}
