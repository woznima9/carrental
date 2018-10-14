package carrentalapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("What a nice name ...")
class CarTest {


    Car car = new Car("Mazda", "VIN12345", "20181010");


    @Test
    @DisplayName("... for a test")
    void showCar() {
        System.out.println(car.getVin());
    }

    @Test
    void getVin() {
    }

    @Test
    void equals() {
    }
}