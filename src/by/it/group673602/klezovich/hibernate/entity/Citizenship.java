package by.it.group673602.klezovich.hibernate.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Citizenship")
@XmlEnum
public enum Citizenship {

    @XmlEnumValue("belorussian")
    BELORUSSIAN,
    @XmlEnumValue("russian")
    RUSSIAN,
    @XmlEnumValue("ukrainian")
    UKRAINIAN,
    @XmlEnumValue("polish")
    POLISH,
    @XmlEnumValue("lithuanian")
    LITHUANIAN;

}
