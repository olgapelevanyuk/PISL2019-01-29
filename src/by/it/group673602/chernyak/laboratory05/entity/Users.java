//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.10 at 10:14:32 AM MSK 
//


package by.it.group673602.chernyak.laboratory05.entity;

import javax.persistence.Entity;
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
    private List<by.bsuir.userhibernate.entity.User> user;

    public List<by.bsuir.userhibernate.entity.User> getUser() {
        if (user == null) {
            user = new ArrayList<by.bsuir.userhibernate.entity.User>();
        }
        return this.user;
    }

    public void setUser(List<by.bsuir.userhibernate.entity.User> user) {
        this.user = user;
    }
}
