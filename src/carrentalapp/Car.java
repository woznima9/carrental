package carrentalapp;

public class Car {
    String model;
    String vin;
    String daylyRate;

    public Car(String model, String vin, String daylyRate) {
        this.model = model;
        this.vin = vin;
        this.daylyRate = daylyRate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", daylyRate='" + daylyRate + '\'' +
                '}';
    }
}
