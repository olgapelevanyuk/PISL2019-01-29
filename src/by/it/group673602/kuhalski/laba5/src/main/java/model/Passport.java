package by.it.group673602.kuhalski.laba5.src.main.java.model;

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
