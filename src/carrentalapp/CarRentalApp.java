package carrentalapp;

import java.io.IOException;
import java.util.*;

public class CarRentalApp {
    static final String filenameClientsData="clients.csv";
    static final String filenameCarsData="cars.csv";
    Map<Client, Car> clientCarRentalMap;
    Set<Car> carsSet;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("car-rental.APP");

        CarRentalApp carRentalApp = new CarRentalApp();
        carRentalApp.clientCarRentalMap = new HashMap<>();
        carRentalApp.mainMenu();
        System.out.println(carRentalApp.clientCarRentalMap);
        System.out.println(carRentalApp.carsSet);

        System.out.println("_______________________");
    }

    void mainMenu() throws InterruptedException {
        KeyReader keyReader = new KeyReader();
        MainMenuOptions option;

        Clients clients = new Clients(clientCarRentalMap);
        carsSet= new HashSet<>();
        Cars cars = new Cars(carsSet);

        showMenu();
        while ((option = MainMenuOptions.getOption(keyReader.getInt() - 1)) != MainMenuOptions.EXIT_App) {
            switch (option) {
                case Enter_Client:
                    System.out.println(MainMenuOptions.Enter_Client.getOptionName());
                    clients.addClient(clientCarRentalMap);
                    break;
                case Show_All_Clients:
                    System.out.println(MainMenuOptions.Show_All_Clients.getOptionName());
                    clients.showAllClientsInAlphabeticalOrder();
                    break;
                case Enter_New_Car:
                    System.out.println(MainMenuOptions.Enter_New_Car.getOptionName());
                    cars.addCar();
                    break;
                case Show_AllCars:
                    System.out.println(MainMenuOptions.Show_AllCars.getOptionName());
                    cars.listAllCars();
                    break;
                case Rent_Car:
                    System.out.println(MainMenuOptions.Rent_Car.getOptionName());
                    RentCar rentCar = new RentCar(clients,cars);
                    rentCar.rent();
                    break;
                case Import_Cars_Clients_Data:
                    System.out.println(MainMenuOptions.Import_Cars_Clients_Data.getOptionName());
                    DataImports dataImports = new DataImports(clientCarRentalMap,carsSet);
                    try {
                        clientCarRentalMap=dataImports.importClientFromFile(filenameClientsData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        carsSet=dataImports.importCarFromFile(filenameCarsData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case EXIT_App:
                    break;
                default:
                    System.out.println("remember - add code for current list");
                    break;
            }
            showMenu();
        }
    }

    void showMenu() {
        System.out.println("_____MAIN_MENU_____");
        Arrays.stream(MainMenuOptions.values()).map(o -> o.getKeyNumber() + " - " + o.getOptionName()).forEach(System.out::println);
        System.out.println("                    .... enter option number\n");
    }
}
