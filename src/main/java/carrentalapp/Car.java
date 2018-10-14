package carrentalapp;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String model;
    private String vin;
    private String daylyRate;
    private boolean isRent;

    Car(String model, String vin, String daylyRate) {
        this.model = model;
        this.vin = vin;
        this.daylyRate = daylyRate;
        this.isRent = false;
    }

    String getModel() {
        return model;
    }

    String getVin() {
        return vin;
    }

    public String getDaylyRate() {
        return daylyRate;
    }

    boolean isRent() {
        return isRent;
    }

    void setRent(boolean rent) {
        this.isRent = rent;
    }

    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", daylyRate='" + daylyRate + '\'' +
                '}';
    }

    public int compareTo(Car o) {
        return this.getVin().compareTo(o.getVin());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getVin(), car.getVin());
    }

    public int hashCode() {
        return Objects.hash(getVin());
    }
}
