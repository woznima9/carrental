package carrentalapp;

import java.util.*;


public class Clients {
    Set<Client> clients = new TreeSet<>();
//Map <Client,Integer> clients = new LinkedHashMap<>();  na mapie nie działa sortowanie jak na kolekcji


    void addClient() {
        KeyReader kr = new KeyReader();
        String name, sureName, birth;
        System.out.println("Enter Name:");
        name = kr.getText();
        System.out.println("Enter Surename:");
        sureName = kr.getText();
        System.out.println("Enter birth of day:");
        birth = kr.getText();
        clients.add(new Client(name, sureName, birth));
    }

    void showAllClientsInAlphabeticalOrder() {

//        SortByName sortByName = new SortByName();
//        Collections.sort(clients, sortByName);  // nie da się SET sortować Collection, ale można sortować lambdą
        clients.stream().sorted(new SortByName()).map(e -> " " + e.clientNumber + e.firstName + ", ").forEach(System.out::println);

//        List<Client> clientsList = new LinkedList<>();
//        clients.stream().forEach(clientsList::add);
//        clientsList.stream().sorted(sortByName).forEach(System.out::println);
//        System.out.println();

    }


}

class SortByName implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        int wynik = o1.firstName.compareTo(o2.firstName);
        if (wynik > 0) return 1;
        if (wynik < 0) return -1;
        return 0;
    }
}