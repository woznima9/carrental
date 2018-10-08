package carrentalapp;

import java.util.*;

public class Cars {
    Map<Car, Client> cars = new HashMap<>();

    void addCar() {
        KeyReader kr = new KeyReader();
        System.out.println("wprowadź model:");
        String model = kr.getText();
        System.out.println("wprowadź vin:");
        String vin = kr.getText();
        System.out.println("wprowadź DayliRate:");
        String dayliRate = kr.getText();

        cars.put(new Car(model, vin, dayliRate), null);
    }


    void listAllCars() {
        cars.keySet().stream().map(Car::showCar).forEach(System.out::println);
    }

    public Map<Car, Client> getCars() {
        return cars;
    }
}
