package by.it.group673601.telesh.lab5.main.service;

/**
 * Created by user on 23.04.2019.
 */

import lab5.dao.Enity.ClientEntity;

import java.util.List;

public interface UserService {

    ClientEntity findById(int id);
    void update(ClientEntity client);
    void save(ClientEntity client);
    void delete(ClientEntity client);
    List<ClientEntity> findAll();

}
