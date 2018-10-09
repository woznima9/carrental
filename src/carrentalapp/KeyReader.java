package carrentalapp;

import java.util.Scanner;

public class KeyReader {
    private String text;
    Scanner scanner = new Scanner(System.in);
    Options option;
    RentSubmenuOption rentSubmenuOption;

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

    int getInt() {
        int key = scanner.nextInt();
        return key;
    }

    RentSubmenuOption rentSubmenuOption() {
        boolean keyNotCorrect;
        do {
            keyNotCorrect = false;
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    rentSubmenuOption = RentSubmenuOption.Point_Client_For_Rent_A_Car;
                    break;
                case 2:
                    rentSubmenuOption = RentSubmenuOption.Point_Car_For_Rental;
                    break;
                case 3:
                    rentSubmenuOption = RentSubmenuOption.Show_all_Rentals_In_Alphabetical_Client;
                    break;
                case 4:
                    rentSubmenuOption = RentSubmenuOption.Show_all_Rentals_In_Alphabetical_Model;
                    break;
                case 5:
                    rentSubmenuOption = RentSubmenuOption.Loose_Car_from_Rental;
                    break;
                case 6:
                    rentSubmenuOption = RentSubmenuOption.EXIT_submenu;
                    break;
                default:
                    System.out.println("DEFAULT in submenu - nie ma takiej opcji");
                    keyNotCorrect = true;
                    break;
            }
        }
        while (keyNotCorrect);
        return rentSubmenuOption;


    }


}