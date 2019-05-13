package by.it.group673602.kuhalski.laba5.src.main.java.model;


import java.io.Serializable;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Person",propOrder = {
        "lastName",
        "firstName",
        "thirdName",
        "gender",
        "birthDate",
        "address",
        "passport",
        "nation",
        "phone",
        "homePhone"
})
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class Person implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long login;
    @XmlElement(required = true)
    private String lastName;
    @XmlElement(required = true)
    private String firstName;
    @XmlElement(required = true)
    private String thirdName;
    @XmlElement(required = true)
    private Passport passport;
    @XmlElement(required = true)
    private Date birthDate;
    @XmlElement(required = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @XmlElement(required = true)
    private Address address;
    @XmlElement(required = true)
    @Enumerated(EnumType.STRING)
    private Nationality nation;
    @XmlElement
    private String phone;
    @XmlElement
    private String homePhone;

}
