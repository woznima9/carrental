package carrentalapp;

import java.io.IOException;
import java.util.Arrays;

public class CarRentalApp {
    Clients clients = new Clients();
    Cars cars = new Cars();
    RentCar fixRental = new RentCar();


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("______car rental_______");
        DataImports dataImports = new DataImports();
        CarRentalApp app = new CarRentalApp();
        app.mainMenu();
        System.out.println("_______________________");
    }

    void mainMenu() throws InterruptedException {
        KeyReader keyReader = new KeyReader();
        boolean execute = true;
        while (execute) {
            showMenu();
            switch (keyReader.pointOption()) {
                case Enter_Client:
                    System.out.println(Options.Enter_Client.getOptionName());
                    clients.addClient();
                    break;
                case Show_All_Clients:
                    System.out.println(Options.Show_All_Clients.getOptionName());
                    clients.showAllClientsInAlphabeticalOrder();
                    break;
                case Enter_New_Car:
                    System.out.println(Options.Enter_New_Car.getOptionName());
                    cars.addCar();
                    break;
                case Show_AllCars:
                    System.out.println(Options.Show_AllCars.getOptionName());
                    cars.listAllCars();
                    break;

                case Rent_Car:
                    System.out.println(Options.Rent_Car.getOptionName());
                    fixRental.rent(clients.getClientsSet(), cars.getCars());
                    break;
                case Import_Cars_Clients_Data:
                    System.out.println(Options.Import_Cars_Clients_Data.getOptionName());
                    DataImports dataImports = new DataImports();
                    try {
                        dataImports.importClientFromFile(clients.getClientsSet());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        dataImports.importCarFromFile(cars.getCars());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case EXIT_App:
                    execute = false;
                    break;
                default:
                    System.out.println("remember - add code for current list");
                    break;
            }
        }
    }

    void showMenu() {
//        for (Options o : Options.values()) {
//            System.out.println(o.getKeyNumber() + " - " + o.getOptionName());
//        }
        System.out.println("__car_rental_main_MENU__");
        Arrays.stream(Options.values()).map(o -> o.getKeyNumber() + " - " + o.getOptionName()).forEach(System.out::println);
        System.out.println("Enter number for option");

    }
}
