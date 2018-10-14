package carrentalapp;

public enum MainMenuOptions {

    ENTER_CLIENT("Enter new client", 1),
    SHOW_ALL_CLIENTS("Show all clients in alphabetical order by name", 2),
    ENTER_NEW_CAR("Enter new car", 3),
    SHOW_ALL_CARS("Show all cars", 4),
    RENT_CAR("Rent a car", 5),
    IMPORT_CARS_AND_CLIENTS_DATA("import data in CSV format for cars and clients", 6),
    EXIT_APP("Exit", 7);

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
