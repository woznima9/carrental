package carrentalapp;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class Clients {
    Map<Client, Car> clientCarMap;

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
        Set<Client> clients = clientCarMap.entrySet().stream().map(c -> c.getKey()).collect(Collectors.toSet());
        System.out.println("Sort in names order:");
        clients.stream().sorted().forEach(System.out::println);
//        System.out.println("sort naturalny");
//        clients.stream().sorted(new SortById()).forEach(System.out::println);
    }

    Client getClient(int key) {
        Collection<Client> cl = new TreeSet<>(clientCarMap.keySet());
        Object[] cT =  cl.toArray();
        return (Client)cT[key];
    }

    Clients rentCar(Client c, Car ca){
        clientCarMap.put(c,ca);

        return (Clients) clientCarMap;
    }

}


//class SortById implements Comparator<Client> {
//    @Override
//    public int compare(Client o1, Client o2) {
//        return Integer.compare(o1.getClientNumber(), o2.getClientNumber());
//    }
//}
//
//class SortByName implements Comparator<Client> {
//    @Override
//    public int compare(Client o1, Client o2) {
//        int wynik = o1.getFirstName().compareTo(o2.getFirstName());
//        if (wynik > 0) return 1;
//        if (wynik < 0) return -1;
//        return 0;
//    }
//}