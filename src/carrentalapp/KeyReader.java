package carrentalapp;

import java.util.Scanner;

public class KeyReader {
    private String key;
    private String text;
    Scanner scanner = new Scanner(System.in);
    Options option;

    Options pointOption() {
        boolean keyNotCorrect;
        do {
            keyNotCorrect = false;
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    option = Options.Enter_Client;
                    break;
                case 2:
                    option = Options.Show_All_Clients;
                    break;
                case 3:
                    option = Options.Enter_New_Car;
                    break;
                case 4:
                    option = Options.Show_AllCars;
                    break;
                case 5:
                    option = Options.Rent_Car;
                    break;
                case 6:
                    option = Options.Import_Cars_Clients_Data;
                    break;
                case 7:
                    option = Options.EXIT_App;
                    break;
                default:
                    keyNotCorrect = true;
                    break;
            }
        }
        while (keyNotCorrect);
        return option;
    }

    String getText() {
        text = scanner.nextLine();

        return text;
    }
}