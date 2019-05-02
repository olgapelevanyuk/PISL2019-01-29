package by.it.group673602.kozlovskaya.lab5.java.logic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Passport", propOrder = {
        "seria",
        "number",
        "idNumber"
})
@Embeddable
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Passport {
    private String seria;
    private String number;
    private String idNumber;
}
