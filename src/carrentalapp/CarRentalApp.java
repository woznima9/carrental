package carrentalapp;

import java.util.TreeSet;

public class CarRentalApp {

    static KeyReader keyReader = new KeyReader();

    public static void main(String[] args) {

        boolean execute = true;
        System.out.println("car rental");
        String keyPressed;
        Clients cl = new Clients();
        do {
            while (execute) {

                CarRentalApp.showMenu();
                System.out.println("wprowadź znak");
                keyPressed = keyReader.getKey();
                switch (Options.valueOf(keyPressed)) {
                    case e:
                        System.out.println(Options.e.getOptionName());
                        cl.addClient();
                        break;
                    case s:
                        System.out.println(Options.s.getOptionName());
                        cl.showAllClientsInAlphabeticalOrder();
                        break;
                    case d:
                        System.out.println(Options.d.getOptionName());
                        break;
                    case f:
                        System.out.println(Options.f.getOptionName());
                        break;

                    case x:
                        execute = false;
                        break;
                    default:
                        System.out.println("Dopisz BARANIE do listy wyboru w tym menu literkę" + Options.valueOf(keyPressed));
                        break;
                }
            }
        }
        while (execute);

        System.out.println("Bye");

    }

    static void showMenu() {
        for (Options o : Options.values()) {
            System.out.println(o + " - " + o.getOptionName());
        }

    }


}
