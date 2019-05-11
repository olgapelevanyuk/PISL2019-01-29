package by.it.group673601.telesh.lab5.data;

/**
 * Created by user on 23.04.2019.
 */
public enum CleintCityLocation {

    MINSK("MINSK"),
    VITEBSK("VITEBSK"),
    GRODNO("GRODNO"),
    GOMEL("GOMEL"),
    BREST("BREST"),
    MOGILEV("MOGILEV");


    CleintCityLocation(String cleintCityLocation) {
    }

    public String getName(){
        return name();
    }
}
