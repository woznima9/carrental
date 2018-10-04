package carrentalapp;

import java.util.ArrayList;
import java.util.Arrays;

public enum Options {
    e("Enter one Client"),
    s("Show all Clients in name alphabetical order"),
    d("robienie czynności D"),
    f("robienie czynności F"),
    x("EXIT");

    private String optionName;


    static public ArrayList<String> getActiveKeysForOptions() {
        ArrayList<String> as = new ArrayList<>();
//        for (Options a : Options.values()) {
//            as.add(a.toString());
//        }
//        Arrays.stream(Options.values()).map(a->a.toString()).forEach(as::add);  // to jest void (jak przekształcić ?
        Arrays.stream(Options.values()).map(a -> a.toString()).forEach(as::add);
        return as;
    }

    Options(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return optionName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
