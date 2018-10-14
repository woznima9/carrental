package carrentalapp;

import java.util.Objects;

public class Client implements Comparable<Client> {
    private static int id = 0;
    private int clientNumber;
    private String firstName;
    private String lastName;
    private String birthDate;

    public Client(String firstName, String lastName, String birthDate) {
        id++;
        clientNumber = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    private int getClientNumber() {
        return clientNumber;
    }

    public String chosenClient() {
        String text = String.format("client: %10s\t\t%10s\t\t(%2d)", getFirstName(), getLastName(), getClientNumber());
        return text;
    }

    public String toString() {
        return "Client{" +
                "clientNumber=" + clientNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public int compareTo(Client o) {
//        return this.clientNumber - o.clientNumber;  // sortowanie naturalne po id
        return this.firstName.compareTo(o.firstName);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName);
    }

    public int hashCode() {
        return Objects.hash(firstName);
    }
}
