package carrentalapp;

public enum MainMenuOptions {
    Enter_Client("Enter one Client", 1),
    Show_All_Clients("Show all Clients in name alphabetical order", 2),
    Enter_New_Car("Enter new Car", 3),
    Show_AllCars("Show all Cars", 4),
    Rent_Car("Rent a car", 5),
    Import_Cars_Clients_Data("import CSV Cars and Clients", 6),
    EXIT_App("EXIT", 7);

    private String optionName;
    private int keyNumber;

    MainMenuOptions(String optionName, int keyNumber) {
        this.optionName = optionName;
        this.keyNumber = keyNumber;
    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public String getOptionName() {
        return optionName;
    }

    static MainMenuOptions getOption(int key) {
        MainMenuOptions[] option = MainMenuOptions.values();
        return option[key];
    }
}
