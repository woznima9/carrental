package carrentalapp;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataImports {

    private Map<Client, Car> clientCarRentalMap;
    private Set<Car> cars;

    DataImports(Map<Client, Car> clientCarRentalMap, Set<Car> cars) {
        this.clientCarRentalMap = clientCarRentalMap;
        this.cars = cars;
    }

    Map<Client, Car> importClientFromFile(String fileName) throws IOException {
        String s;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] meta;
        while ((s = in.readLine()) != null) {
            meta = s.split(";");
            clientCarRentalMap.put(new Client(meta[0], meta[1], meta[2]), null);
        }
        in.close();
        return clientCarRentalMap;
    }

    Set<Car> importCarFromFile(String filename) throws IOException {
        String s;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] meta;
        while ((s = in.readLine()) != null) {
            meta = s.split(";");
            cars.add(new Car(meta[0], meta[1], meta[2]));
        }
        in.close();
        return cars;
    }

}
