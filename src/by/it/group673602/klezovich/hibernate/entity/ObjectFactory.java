package by.it.group673602.klezovich.hibernate.entity;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xmlparsing.users
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Users }
     *
     */
    public Users createUsers() {
        return new Users();
    }

    /**
     * Create an instance of {@link User }
     *
     */
    public User createUsersUser() {
        return new User();
    }

}
