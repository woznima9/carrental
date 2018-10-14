package carrentalapp;

import java.util.Scanner;

class KeyReader {
    private Scanner scanner = new Scanner(System.in);


    String getText() {
        String text = scanner.nextLine();
        return text;
    }

    int getInt() {
        int key = scanner.nextInt();
        return key;
    }

}