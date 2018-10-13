package carrentalapp;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    Set<Car> cars;

    public Cars(Set<Car> carsSet) {
        this.cars = carsSet;

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


    void listAllCars() {
        cars.stream().map(Car::showCar).forEach(System.out::println);
    }

    public Set<Car> getCars() {
        return cars;
    }

    public Car getCar(int key) {
        Collection<Car> c = new TreeSet<>(cars);
        Object[] cA=c.toArray();
        return (Car)cA[key];
    }
}
