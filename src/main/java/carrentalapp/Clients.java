package carrentalapp;

import java.util.*;
import java.util.stream.Collectors;


public class Clients {
    Map<Client, Car> clientCarMap;
    private TreeSet<Client> clients;

    public Clients(Map<Client, Car> clientCarMap) {
        this.clientCarMap = clientCarMap;
    }

    Map<Client, Car> addClient(Map<Client, Car> clientCarMap) {
        KeyReader kr = new KeyReader();
        String name, sureName, birth;
        System.out.println("Enter Name:");
        name = kr.getText();
        System.out.println("Enter Surename:");
        sureName = kr.getText();
        System.out.println("Enter birth of day:");
        birth = kr.getText();
        clientCarMap.put(new Client(name, sureName, birth), null);
        return clientCarMap;
    }

    void showAllClientsInAlphabeticalOrder() {
        clients = clientCarMap.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Sort in names order:");
        int i = 1;
        for (Client c : clients) {
            System.out.println(i++ + " - " + c.getFirstName() + " " + c.getLastName());
        }
    }

    Client getClient(int key) {
        Object[] cT = clients.toArray();
        return (Client) cT[key - 1];
    }

    void rentCar(Client c, Car ca) {

        Car temp = clientCarMap.get(c);
        if (temp != null) {
            temp.setRent(false);
        }

        ca.setRent(true);
        clientCarMap.put(c, ca);
    }
}

