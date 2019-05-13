package by.it.group673602.kuhalski.laba5.src.main.java.model;

@XmlType
@XmlEnum(String.class)
public enum Gender{
    @XmlEnumValue("Мужской") MAN("Мужской"),
    @XmlEnumValue("Женский") WOMAN("Женский");

    private String value;

    Gender(String s){
        this.value = s;
    }

    @Override
    public String toString(){
        return value;
    }
}
