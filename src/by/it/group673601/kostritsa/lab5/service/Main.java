package by.it.group673601.kostritsa.lab5.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab5.entity.Citizen;
import lab5.resource.Citizens;
import lab5.resource.Citizenship;
import lab5.resource.CurrentCityLocation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Citizens.class);
        Marshaller m = context.createMarshaller();

        File xmlFile = new File("result.xml");

        Citizens citizens = new Citizens();
        List<Citizen> citizenList = new ArrayList<>();
        Citizen citizen = new Citizen();
        citizen.setBirthday(new Date());
        citizen.setId("1");
        citizen.setName("name");
        citizen.setSurname("surname");
        citizen.setPatronymic("patronymic");
        citizen.setPassportSerial("passport serial");
        citizen.setCurrentCityLocation(CurrentCityLocation.MINSK);
        citizen.setCurrentAddress("address");
        citizen.setMobileNumber("+37533432434");
        citizen.setEmail("email");
        citizen.setHasJob(true);
        citizen.setPosition("position");
        citizen.setRegistrationAddress("reg address");
        citizen.setCitizenship(Citizenship.BELARUS);

        citizenList.add(citizen);
        citizens.setList(citizenList);

        System.out.println("Creating new xml xmlFile...");
        m.marshal(citizens, new FileOutputStream(xmlFile));
        m.marshal(citizens, System.out);

        System.out.println("\nSaving in mysql db from xml...");
        OrganizationDAO dao = new OrganizationDAO();
        citizens.getList().forEach(dao::save);

        System.out.println("Saving result:\n" + dao.findAll());

        System.out.println("Updating one citizen setting new email...");
        citizen.setEmail("new email");
        dao.update(citizen);
        System.out.println(dao.findAll());

        System.out.println("Removing from db...");
        dao.delete(citizen);
        System.out.println(dao.findAll());

        System.out.println("Getting info from xml...");
        System.out.println(getCitizensFromXml(xmlFile));

        File jsonFile = new File("result.json");

        System.out.println("Writing into json file...");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(jsonFile, citizens);

        System.out.println("Getting info from json file...");
        System.out.println(objectMapper.readValue(jsonFile, Citizens.class));
    }

    public static List<Citizen> getCitizensFromXml(File file) throws JAXBException {
        JAXBContext js = JAXBContext.newInstance(Citizens.class);
        Unmarshaller u = js.createUnmarshaller();
        Citizens citizens = (Citizens) u.unmarshal(file);
        return citizens.getList();
    }
}
