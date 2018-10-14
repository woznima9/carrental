package carrentalapp;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private Collection<Car> cars;
    private Collection<Car> carsforRent;

    Cars(Set<Car> cars) {
        this.cars = cars;
    }

    void addCar() {
        KeyReader kr = new KeyReader();
        System.out.println("wprowadź model:");
        String model = kr.getText();
        System.out.println("wprowadź vin:");
        String vin = kr.getText();
        System.out.println("wprowadź DayliRate:");
        String dayliRate = kr.getText();
        System.out.println(dayliRate);
        cars.add(new Car(model, vin, dayliRate));
    }


    void listAllCarsReadyToRent() {
        carsforRent = cars.stream().filter(c -> !c.isRent()).collect(Collectors.toList());
        int i = 1;
        for (Car c : carsforRent) {
            System.out.println(i++ + " - " + c.getModel() + ", " + c.getVin());
        }
    }

    public Collection<Car> getCars() {
        return cars;
    }

    Car getCarReadyToRent(int key) {
        Object[] cA = carsforRent.toArray();
        return (Car) cA[key - 1];
    }

    void listAllCars() {
        int i = 1;
        for (Car c : cars) {
            System.out.println(i++ + " - " + c.getModel() + ", " + c.getVin() + " " + c.isRent());
        }
    }
}
