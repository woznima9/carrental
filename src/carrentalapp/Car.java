package carrentalapp;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String model;
    private String vin;
    private String daylyRate;

    public Car(String model, String vin, String daylyRate) {
        this.model = model;
        this.vin = vin;
        this.daylyRate = daylyRate;
    }

    public String showCar() {
        String CarTxt = getModel() + "  " + getVin();
        return CarTxt;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public String getDaylyRate() {
        return daylyRate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", daylyRate='" + daylyRate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.getVin().compareTo(o.getVin());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getVin(), car.getVin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin());
    }
}
