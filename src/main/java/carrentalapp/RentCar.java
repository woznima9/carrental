package carrentalapp;

import java.util.*;

import static carrentalapp.RentSubmenuOption.getRentSubmenuOption;


public class RentCar {
    private KeyReader kre = new KeyReader();
    private Clients clients;
    private Cars cars;
    private Client c;
    private Car car;

    public RentCar(Clients clients, Cars cars) {
        this.clients = clients;
        this.cars = cars;
    }

    void rent() throws InterruptedException {
        rentSubmenu();
    }

    void rentSubmenu() throws InterruptedException {
        RentSubmenuOption option;
        showSubmenu();
        while ((option = getRentSubmenuOption(kre.getInt() - 1)) != RentSubmenuOption.EXIT_SUBMENU) {
            switch (option) {
                case POINT_CLIENT_FOR_CAR_RENTING:
                    System.out.println("Piont the Client:");
                    clients.showAllClientsInAlphabeticalOrder();
                    c = clients.getClient(kre.getInt());
                    System.out.println("rental client is " + c + "\n");
                    break;
                case POINT_CAR_FOR_RENTAL:
                    System.out.println("Piont Car for rent:");
                    cars.listAllCarsReadyToRent();
                    car = cars.getCarReadyToRent(kre.getInt());
                    System.out.println("car for rent is : " + car);
                    clients.rentCar(c, car);
                    break;
                case SHOW_ALL_RRENTALS_IN_ALPHABETICAL_CLIENT:
                    System.out.println("Shw all rental Clients");
                    break;
                case SHOW_ALL_RENTALS_IN_ALPHABETICAL_CAR_MODEL:
                    System.out.println("Shw all rental Cars");
                    showAllRentals();
                    break;
                case LOOSE_CAR_FROM_RENTAL:
                    System.out.println("Lose car TODO");
                    break;
                case EXIT_SUBMENU:
                    break;
                default:
                    System.out.println("No Submenu option");
                    break;
            }
            showSubmenu();
        }
    }


    private void showSubmenu() {
        System.out.println("\n__SUBMENU__car_rental___");
        Arrays.stream(RentSubmenuOption.values()).map(c -> c.getActiveKey() + " " + c).forEach(System.out::println);
        System.out.println("Enter operation for rental:");

    }

    private void showAllRentals() {

        for (Map.Entry<Client, Car> c : clients.clientCarMap.entrySet()) {
            if (c.getValue() != null)
                System.out.println(c.getKey().getFirstName() + " " + c.getValue().getModel());
        }
    }
}
