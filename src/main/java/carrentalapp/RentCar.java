package carrentalapp;

import java.util.*;
import java.util.stream.Collectors;

import static carrentalapp.RentSubmenuOption.getRentSubmenuOption;


public class RentCar {
    KeyReader kre = new KeyReader();
    Clients clients;
    Cars cars;
    Client c;
    Car car;

    public RentCar(Clients clients, Cars cars) {
        this.clients = clients;
        this.cars = cars;
    }

    void rent() throws InterruptedException {
        showSubmenu();
        rentSubmenu();
        clients.rentCar(c, car);


//        System.out.println("Zarejestrowani Klienci");
//        clients.stream().map(client -> "Client: "+client.firstName + " "+client.lastName).forEach(System.out::println);
//        System.out.println("posiadane auta");
//        cars.keySet().stream().map(car -> "Car: " + car.getModel()+" "+car.getVin()).forEach(System.out::println);
//
//        System.out.println("Klient o id 3 pozycza car o id Mazda ");
//        System.out.println("listing carów z przypisanymi klientami");
//        Car tempCar;
//        Car lookingCar = null;
//        Iterator carIterator = cars.keySet().iterator();
//        while (carIterator.hasNext()) {
//            tempCar = (Car) carIterator.next();
//            System.out.println(tempCar.getVin());
//            if (tempCar.getVin().equals("CEC45168")) {
//                lookingCar = tempCar;
//            }
//        }
//        System.out.println("poszukiwany samochód :" + lookingCar.getModel() + " " + lookingCar.getVin());
//
//        Client client;
//        Client rentClient = null;
//        Iterator clientIterator = clients.iterator();
//        while (clientIterator.hasNext()) {
//            client = (Client) clientIterator.next();
//            if (client.firstName.equals("Anna")) {
//                rentClient = client;
//            }
//        }
//
//        cars.replace(lookingCar, rentClient);
//
//        System.out.println("szukam drugiego klienta lambdą  ?Jasio?");
////        boolean lookingForJasio = clients
//
//
//        for (Map.Entry<Car, Client> entry : cars.entrySet()) {
//            if (entry.getValue() instanceof Client) {
//                System.out.println("LISTING:" + entry.getKey().getModel() + " @@ " + entry.getValue().firstName);
//            }
//        }
//        System.out.println("to samo lambdą");
//        cars.forEach((key, value) -> System.out.println((key + " lambdą " + value)));
//        System.out.println("z warunkiem");
//        boolean looking = cars.containsValue(rentClient);
//        System.out.println(looking);
//
//
//        System.out.println(cars);
//        cars.entrySet().stream().forEach(System.out::println);

//        Iterator carIterator = cars.keySet().iterator();
//        while (carIterator.hasNext()) {
//            Map.Entry<Car, Client> pair = (Map.Entry<Car, Client>) carIterator.next();
//            System.out.println("klucz car "+pair.getKey() + " = " + pair.getValue());
//
//        }
//        System.out.println("czy coś wyświetlił");


    }

    void rentSubmenu() throws InterruptedException {
        RentSubmenuOption option;

        showSubmenu();
        while ((option = getRentSubmenuOption(kre.getInt() - 1)) != RentSubmenuOption.EXIT_submenu) {
            switch (option) {
                case Point_Client_For_Rent_A_Car:
                    System.out.println("Piont the Client:");
                    System.out.println("...choice Client to rent a car");
                    clients.showAllClientsInAlphabeticalOrder();
                    c = clients.getClient(kre.getInt());
                    System.out.println("Wybrano klienta " + c);
                    System.out.println("SSTTIIOOPP");
                    Thread.sleep(3000);
                    break;
                case Point_Car_For_Rental:
                    System.out.println("Piont Car for rent:");
                    cars.listAllCars();
                    car = cars.getCar(kre.getInt());
                    System.out.println("Wtbrano Cara: " + car);

                    Thread.sleep(3000);

                    break;
                case Show_all_Rentals_In_Alphabetical_Client:
                    System.out.println("Shw all rental Clients");
                    Thread.sleep(3000);

                    break;
                case Show_all_Rentals_In_Alphabetical_Model:
                    System.out.println("Shw all rental Cars");
                    Thread.sleep(3000);

                    break;
                case Loose_Car_from_Rental:
                    System.out.println("Lose car TODO");

                    Thread.sleep(3000);
                    break;
                case EXIT_submenu:
                    System.out.println("ustawiam zmienną na wyjście");
                    break;
                default:
                    System.out.println("DEFOULT submenu");
                    break;
            }
            showSubmenu();
        }

        System.out.println("WYSZEDŁ");
    }


    void showSubmenu() {
        System.out.println("\n__SUBMENU__car_rental___");
        Arrays.stream(RentSubmenuOption.values()).map(c -> c.getActiveKey() + " " + c).forEach(System.out::println);
        System.out.println("Enter operation for rental:");

    }

}
