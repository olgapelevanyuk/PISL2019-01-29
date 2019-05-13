package by.it.group673602.klezovich.hibernate.entity;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "user"
})
@XmlRootElement(name = "users")
@Entity
public class Users {

    @XmlElement(required = true)
    private List<User> user;

    public List<User> getUser() {
        if (user == null) {
            user = new ArrayList<User>();
        }
        return this.user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}

