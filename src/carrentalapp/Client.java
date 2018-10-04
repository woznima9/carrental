package carrentalapp;

public class Client implements Comparable<Client> {
    static int id = 0;
    int clientNumber;
    String firstName;
    String lastName;
    String birthDate;

    public Client(String firstName, String lastName, String birthDate) {
        id++;
        clientNumber = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientNumber=" + clientNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        return this.clientNumber - o.clientNumber;  // sortowanie naturalne po id
//        return this.firstName.compareTo(o.firstName);
    }
}
