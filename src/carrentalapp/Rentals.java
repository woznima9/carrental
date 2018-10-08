package carrentalapp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Rentals {
    Map<Client, Car> rentalMap = new HashMap<>();

    void rentals(Set<Client> clients, Set<Car> cars) {
        System.out.println("proces przypisania Auta do klienta");
        clients.stream().map(client -> "Client: " + client.firstName).forEach(System.out::println);
        cars.stream().map(car -> "Car: " + car.getModel()).forEach(System.out::println);


        Iterator iterator = rentalMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Client, Car> pair = (Map.Entry<Client, Car>) iterator.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());

        }


    }

    void showRentals() {
        for (Map.Entry<Client, Car> entry : rentalMap.entrySet()) {
            System.out.println(entry.getKey() + "wyporzyczył -" + entry.getValue());
        }

    }

}
