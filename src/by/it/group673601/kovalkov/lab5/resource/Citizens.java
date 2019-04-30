package lab5.resource;

import lab5.entity.Citizen;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
@XmlRootElement(name = "citizens")
@XmlAccessorType(XmlAccessType.FIELD)
public class Citizens {
    @Getter
    @Setter
    @XmlElement(name = "citizen")
    private List<Citizen> list;

    public Citizens() {
        this.list = new ArrayList<>();
    }
}
