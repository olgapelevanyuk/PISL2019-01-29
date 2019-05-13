package by.it.group673602.kuhalski.laba5.src.main.java.model;

import sun.jvm.hotspot.debugger.cdbg.EnumType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Address", propOrder = {
        "actualCity",
        "actualAddress",
        "releaseCity",
        "releaseAddress"
})
@Embeddable
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {
    @Enumerated(EnumType.STRING)
    private City actualCity;
    private String actualAddress;
    @Enumerated(EnumType.STRING)
    private City releaseCity;
    private String releaseAddress;
}
