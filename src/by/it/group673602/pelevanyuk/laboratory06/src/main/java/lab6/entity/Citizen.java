package lab6.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lab6.json.DataDeserializer;
import lab6.resource.Citizenship;
import lab6.resource.CurrentCityLocation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
@Table(name = "citizens")
public class Citizen {
    @Id
    @NotBlank(message = "Id can not be null")
    private String id;
    @NotBlank(message = "name can not be null")
    private String name;
    @NotBlank(message = "surname can not be null")
    private String surname;
    @NotBlank(message = "patronymic can not be null")
    private String patronymic;
    @NotNull(message = "birthday can not be null")
    @JsonDeserialize(using = DataDeserializer.class)
    private Date birthday;
    private String passportSerial;
    @Enumerated(EnumType.STRING)
    private CurrentCityLocation currentCityLocation;
    @NotBlank(message = "currentAddress can not be null")
    private String currentAddress;
    private String mobileNumber;
    private String email;
    private boolean hasJob;
    private String position;
    @NotBlank(message = "registrationAddress can not be null")
    private String registrationAddress;
    @Enumerated(EnumType.STRING)
    private Citizenship citizenship;
}
