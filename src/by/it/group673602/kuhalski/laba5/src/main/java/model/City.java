package by.it.group673602.kuhalski.laba5.src.main.java.model;

@XmlType
@XmlEnum
public enum City {
    @XmlEnumValue("Минск") MINSK("Минск"),
    @XmlEnumValue("Гродно") GRODNO("Гродно"),
    @XmlEnumValue("Гомель") GOMEL("Гомель"),
    @XmlEnumValue("Витебск") VITEBSK("Витебск"),
    @XmlEnumValue("Брест") BREST("Брест");

    private String value;

    City(String s){
        this.value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
