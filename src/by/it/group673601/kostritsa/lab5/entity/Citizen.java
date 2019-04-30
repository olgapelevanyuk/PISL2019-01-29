package by.it.group673601.kostritsa.lab5.entity;

import lab5.resource.Citizenship;
import lab5.resource.CurrentCityLocation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
@Table(name = "citizens")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Citizen {
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlAttribute(required = true)
    @XmlID
    @Id
    private String id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String surname;
    @XmlElement(required = true)
    private String patronymic;
    @XmlElement(required = true)
    private Date birthday;
    @XmlElement(required = true)
    private String passportSerial;
    @XmlElement(required = true)
    @Enumerated(EnumType.STRING)
    private CurrentCityLocation currentCityLocation;
    @XmlElement(required = true)
    private String currentAddress;
    @XmlElement(required = false)
    private String mobileNumber;
    @XmlElement(required = false)
    private String email;
    @XmlElement(required = false)
    private boolean hasJob;
    @XmlElement(required = false)
    private String position;
    @XmlElement(required = true)
    private String registrationAddress;
    @XmlElement(required = true)
    @Enumerated(EnumType.STRING)
    private Citizenship citizenship;
}
