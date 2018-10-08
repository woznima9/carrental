package carrentalapp;

import java.util.*;

public class Clients {
    Set<Client> clientsHS = new HashSet<>();

    void addClient() {
        KeyReader kr = new KeyReader();
        String name, sureName, birth;
        System.out.println("Enter Name:");
        name = kr.getText();
        System.out.println("Enter Surename:");
        sureName = kr.getText();
        System.out.println("Enter birth of day:");
        birth = kr.getText();
        clientsHS.add(new Client(name, sureName, birth));
    }

    void showAllClientsInAlphabeticalOrder() {
        clientsHS.stream().sorted(new SortByName()).map(c -> c.firstName).forEach(System.out::println);
    }

    Set<Client> getClientsSet() {
        return clientsHS;
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

    class SortById implements Comparator<Client> {
        @Override
        public int compare(Client o1, Client o2) {
            return Integer.compare(o1.clientNumber, o2.clientNumber);
        }
    }
}