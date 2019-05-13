package by.it.group673601.telesh.lab5.main.service;

import lab5.dao.ClientDao;
import lab5.dao.Enity.ClientEntity;

import java.util.List;

/**
 * Created by user on 23.04.2019.
 */
public class UserServiceImpl implements UserService {

     ClientDao clientDao = new ClientDao();

    public ClientEntity findById(int id) {
        return clientDao.findById(id);
    }

    public void update(ClientEntity client) {
        clientDao.update(client);
    }

    public void save(ClientEntity client) {
         clientDao.save(client);
    }

    public void delete(ClientEntity client) {
         clientDao.delete(client);
    }

    public List<ClientEntity> findAll() {
        return clientDao.findAll();
    }

}
