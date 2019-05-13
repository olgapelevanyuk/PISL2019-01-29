package by.it.group673601.telesh.lab5.utils;

import lab5.dao.Enity.ClientEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by user on 25.04.2019.
 */
public class JaxbWorker {

  private String fileName = "C:\\Users\\user\\IdeaProjects\\hibernate.lab5\\src\\main\\resources\\Client.xml";

    // восстанавливаем объект из XML файла
    public ClientEntity fromXmlToObject() {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(ClientEntity.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (ClientEntity) un.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
    public void convertObjectToXml(ClientEntity clientEntity) {
        try {
            JAXBContext context = JAXBContext.newInstance(ClientEntity.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(clientEntity, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
