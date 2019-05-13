package bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Client {
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private String passportSerialNumber;
    private String passportNumber;
    private String whoGivePassport;
    private String passportGivenDate;
    @Id
    private String passportId;
    private String hometown;
    @Enumerated(value = EnumType.STRING)
    private City currentCityLocation;
    private String address;
    private String homePhoneNumber;
    private String mobilePhone;
    private String email;
    private String job;
    private String residenceAddress;
    @Enumerated(value = EnumType.STRING)
    private MaritalStatus maritalStatus;
    @Enumerated(value = EnumType.STRING)
    private Citizenship citizenship;
    @Enumerated(value = EnumType.STRING)
    private Disability disability;
    private String isRetiree;
    private String monthlyIncome;
}
