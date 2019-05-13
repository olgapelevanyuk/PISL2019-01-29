package by.it.group673602.kuhalski.laba5.src.main.java.model;


@XmlType
@XmlEnum
public enum Nationality {
    @XmlEnumValue("Беларус") BELARUS("Беларус"),
    @XmlEnumValue("Россиянин") RUSSIAN("Россиянин"),
    @XmlEnumValue("Украинец") UKRAIN("Украинец"),
    @XmlEnumValue("Казах") KAZAHSTAN("Казах");

    private String value;

    Nationality(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
