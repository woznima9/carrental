package carrentalapp;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataImports {


    Set<Client> importClientFromFile(Set<Client> clientsHS) throws IOException {
        String s;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("clients.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] meta;
        while ((s = in.readLine()) != null) {
            meta = s.split(";");
            clientsHS.add(new Client(meta[0], meta[1], meta[2]));
        }
        in.close();
        return clientsHS;
    }

    Map<Car, Client> importCarFromFile(Map<Car, Client> cars) throws IOException {
        String s;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("cars.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] meta;
        while ((s = in.readLine()) != null) {
            meta = s.split(";");
            cars.put(new Car(meta[0], meta[1], meta[2]), null);
        }
        in.close();
        return cars;
    }
}
