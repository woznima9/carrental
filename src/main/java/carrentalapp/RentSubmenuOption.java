package carrentalapp;

public enum RentSubmenuOption {
    Point_Client_For_Rent_A_Car(1),
    Point_Car_For_Rental(2),
    Show_all_Rentals_In_Alphabetical_Client(3),
    Show_all_Rentals_In_Alphabetical_Model(4),
    Loose_Car_from_Rental(5),
    EXIT_submenu(6);

    private int activeKey;

    RentSubmenuOption(int activeKey) {
        this.activeKey = activeKey;
    }

    public int getActiveKey() {
        return activeKey;
    }

    static RentSubmenuOption getRentSubmenuOption(int key) {
        RentSubmenuOption[] option = RentSubmenuOption.values();
        return option[key];
    }
}
