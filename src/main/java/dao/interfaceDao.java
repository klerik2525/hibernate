package dao;

import models.Auto;
import models.User;

import java.util.List;

public interface interfaceDao {

     User findById(int id);
     void save(User user);
     void update(User user);
     Auto findAutoById(int id);
     List<User> findAll();
     User findByName(String name);


}
