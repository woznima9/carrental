package setsexamples;

import java.util.Scanner;

public class KeyboardService {

    Scanner sc = new Scanner(System.in);

    char getChar(String instruction) {
        sc.reset();
        System.out.println("***" + instruction);
        char output = sc.next().charAt(0);
        return output;
    }


}
