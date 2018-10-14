package carrentalapp;

import java.io.IOException;
import java.util.*;

public class CarRentalApp {
    private static final String filenameClientsData = "clients.csv";
    private static final String filenameCarsData = "cars.csv";
    private static Clients clients;
    private Map<Client, Car> clientCarRentalMap;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("car-rental.APP");

        CarRentalApp carRentalApp = new CarRentalApp();
        carRentalApp.clientCarRentalMap = new HashMap<>();
        clients = new Clients(carRentalApp.clientCarRentalMap);

        carRentalApp.mainMenu();
        System.out.println("Actual rental list:");
        carRentalApp.clientCarRentalMap.entrySet().stream().map(carRentalApp::carRentalStatus).forEach(System.out::println);
        System.out.println("_______________________");
    }


    private void mainMenu() throws InterruptedException {
        Set<Car> carsSet = new HashSet<>();
        Cars cars = new Cars(carsSet);

        KeyReader keyReader = new KeyReader();
        MainMenuOptions option;
        showMenu();
        while ((option = MainMenuOptions.getOption(keyReader.getInt() - 1)) != MainMenuOptions.EXIT_APP) {
            switch (option) {
                case ENTER_CLIENT:
                    System.out.println(MainMenuOptions.ENTER_CLIENT.getOptionName());
                    clients.addClient(clientCarRentalMap);
                    break;
                case SHOW_ALL_CLIENTS:
                    System.out.println(MainMenuOptions.SHOW_ALL_CLIENTS.getOptionName());
                    clients.showAllClientsInAlphabeticalOrder();
                    break;
                case ENTER_NEW_CAR:
                    System.out.println(MainMenuOptions.ENTER_NEW_CAR.getOptionName());
                    cars.addCar();
                    break;
                case SHOW_ALL_CARS:
                    System.out.println(MainMenuOptions.SHOW_ALL_CARS.getOptionName());
                    cars.listAllCars();
                    break;
                case RENT_CAR:
                    System.out.println(MainMenuOptions.RENT_CAR.getOptionName());
                    RentCar rentCar = new RentCar(clients, cars);
                    rentCar.rent();
                    break;
                case IMPORT_CARS_AND_CLIENTS_DATA:
                    System.out.println(MainMenuOptions.IMPORT_CARS_AND_CLIENTS_DATA.getOptionName());
                    DataImports dataImports = new DataImports(clientCarRentalMap, carsSet);
                    try {
                        clientCarRentalMap = dataImports.importClientFromFile(filenameClientsData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        carsSet = dataImports.importCarFromFile(filenameCarsData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case EXIT_APP:
                    break;
                default:
                    System.out.println("remember - add code for current list");
                    break;
            }
            showMenu();
        }
    }

    private void showMenu() {
        System.out.println("_____MAIN_MENU_____");
        Arrays.stream(MainMenuOptions.values()).map(o -> o.getKeyNumber() + " - " + o.getOptionName()).forEach(System.out::println);
        System.out.println("                    .... enter option number\n");
    }

    private String carRentalStatus(Map.Entry<Client, Car> entry) {
        String takenCarInfo = " no car";
        if (entry.getValue() != null) {
            takenCarInfo = String.format(" car %8s %8s", entry.getValue().getModel(), entry.getValue().getVin());
        }
        return String.format("client: %8s ", entry.getKey().getFirstName()) + takenCarInfo;
    }
}
