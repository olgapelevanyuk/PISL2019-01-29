package by.it.group673602.chernyak.laboratory05;

import by.bsuir.userhibernate.entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws Exception {
        List<User> usersList = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("by.bsuir.userhibernate.entity");
            Unmarshaller um = jc.createUnmarshaller();
            by.bsuir.userhibernate.entity.Users users = (by.bsuir.userhibernate.entity.Users) um.unmarshal(new File("userdata.xsd.xml"));
            usersList = users.getUser();
        } catch (JAXBException e) {
            System.err.println(e.toString());
        }
        System.out.println("Users from XML ");
        by.bsuir.userhibernate.dao.UserdataDaoImpl userdataDao = by.bsuir.userhibernate.dao.UserdataDaoImpl.getInstance();
        for (by.bsuir.userhibernate.entity.User user : usersList) {
            System.out.println(user);
            userdataDao.update(user);
        }

        List<User> foundUser = userdataDao.findAll();
        JAXBContext context = JAXBContext.newInstance(by.bsuir.userhibernate.entity.Users.class);
        Marshaller m = context.createMarshaller();
        by.bsuir.userhibernate.entity.Users users = new by.bsuir.userhibernate.entity.Users();
        users.setUser(foundUser);
        m.marshal(users, new FileOutputStream("users_marsh.xml"));
    }
}