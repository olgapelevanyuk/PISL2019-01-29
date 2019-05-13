package by.it.group673602.klezovich.hibernate.entity;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "City")
@XmlEnum
public enum City {

    @XmlEnumValue("Minsk")
    MINSK,
    @XmlEnumValue("Gomel")
    GOMEL,
    @XmlEnumValue("Grodno")
    GRODNO,
    @XmlEnumValue("Vitebsk")
    VITEBSK,
    @XmlEnumValue("Brest")
    BREST,
    @XmlEnumValue("Mogilev")
    MOGILEV;


}
