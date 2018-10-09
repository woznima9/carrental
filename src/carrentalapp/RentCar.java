package carrentalapp;

import java.util.*;
import java.util.stream.Collectors;

public class RentCar {
    KeyReader kre = new KeyReader();

    void rent(Set<Client> clients, Map<Car, Client> cars) throws InterruptedException {
        rentSubmenu(clients, cars);

        System.out.println("SSTTTTTTTTTTTTTOOOOOOOOOOOOOPPPPPPPPPPPP");
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

    private void rentSubmenu(Set<Client> clients, Map<Car, Client> cars) throws InterruptedException {

        boolean noExitSubmenu = true;
        do {
            showSubmenu();
            switch (kre.rentSubmenuOption()) {
                case Point_Client_For_Rent_A_Car:
                    System.out.println("Piont the Client:");
                    Client client = pointAClient(clients);
                    System.out.println("Pionted Client completed.!!");
                    Thread.sleep(3000);
                    break;
                case Point_Car_For_Rental:
                    System.out.println("Piont Car for rent:");
                    Car car = pointACar(cars);
                    break;
                case Show_all_Rentals_In_Alphabetical_Client:
                    System.out.println("Shw all rental Clients");
//                    showAllRentalsInAlphabeticalClient();
                    break;
                case Show_all_Rentals_In_Alphabetical_Model:
                    System.out.println("Shw all rental Cars");
//                    showAllRentalsInAlphabeticalModel();
                    break;
                case Loose_Car_from_Rental:
                    System.out.println("Lose car TODO");
                    break;
                case EXIT_submenu:
                    System.out.println("ustawiam zmienną na wyjście");
                    noExitSubmenu = false;
                    break;
                default:
                    System.out.println("DEFOULT submenu");
                    break;
            }
        } while (noExitSubmenu);

        System.out.println("WYSZEDŁ");
    }


    Client pointAClient(Set<Client> clients) {
        String name = "";
        Client returnedClient = null;
        List<Client> tempClients;
        tempClients = clients.stream().sorted(Client::compareTo).collect(Collectors.toList());
        tempClients.stream().map(c -> c.getClientNumber() + " " + c.getFirstName() + " " + c.getLastName()).forEach(System.out::println);
        System.out.println("get Client number: (UWAGA licz od zera od góry");
        int clientIndex = kre.getInt() - 1;
        try {
            returnedClient = tempClients.get(clientIndex);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println("Najpierw załaduj dane");
        } finally {
            System.out.println("wykonało się finally");
        }
        System.out.println(returnedClient.chosenClient());
        return returnedClient;
    }

    Car pointACar(Map<Car, Client> cars) {
        String vin = "CEC45168";
        List<Car> tempCar = new ArrayList<>();
        Iterator carIterator = cars.values().iterator();
        while (carIterator.hasNext()) {
            System.out.println(carIterator.next().toString());
        }
        return null;
    }

    void showSubmenu() {
        System.out.println("__SUBMENU__car_rental___");
        Arrays.stream(RentSubmenuOption.values()).map(c -> c.getActiveKey() + " " + c).forEach(System.out::println);
        System.out.println("Enter operation for rental:");

    }

}
