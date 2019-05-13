package by.it.group673601.telesh.lab5.main;

import lab5.dao.Enity.ClientEntity;
import lab5.main.service.UserServiceImpl;
import lab5.utils.JaxbWorker;

/**
 * Created by user on 23.04.2019.
 */
public class AppMain {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        JaxbWorker jaxbWorker = new JaxbWorker();

       /*
        clientEntity.setId(1);
        clientEntity.setFirstName("Vladislav");
        clientEntity.setLastName("Telesh");
        clientEntity.setPatronymic("Vadimovich");
        clientEntity.setDateOfBirth(new Date());
        clientEntity.setPassportSeries("MP3403436");
        clientEntity.setNumberPassport(12324125);
        clientEntity.setHomeAdress(CleintCityLocation.MINSK.getName());
        clientEntity.setMobilePhone("+37596070381");*/

       // jaxbWorker.convertObjectToXml(clientEntity);

        ClientEntity clientEntity = jaxbWorker.fromXmlToObject();
        userService.update(clientEntity);

    }
}
