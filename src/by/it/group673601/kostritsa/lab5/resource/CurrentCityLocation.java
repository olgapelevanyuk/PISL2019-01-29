package by.it.group673601.kostritsa.lab5.resource;

public enum CurrentCityLocation {
    MINSK("MINSK"),
    VITEBSK("VITEBSK"),
    GRODNO("GRODNO"),
    GOMEL("GOMEL"),
    BREST("BREST"),
    MOGILEV("MOGILEV");

    CurrentCityLocation(String currentCityLocation) {
    }

    public String getName(){
        return name();
    }
}
