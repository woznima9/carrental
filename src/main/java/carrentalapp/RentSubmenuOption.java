package carrentalapp;

public enum RentSubmenuOption {

    POINT_CLIENT_FOR_CAR_RENTING(1),
    POINT_CAR_FOR_RENTAL(2),
    SHOW_ALL_RRENTALS_IN_ALPHABETICAL_CLIENT(3),
    SHOW_ALL_RENTALS_IN_ALPHABETICAL_CAR_MODEL(4),
    LOOSE_CAR_FROM_RENTAL(5),
    EXIT_SUBMENU(6);

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
