package services;

import dao.UserDao;
import models.Auto;
import models.User;

import java.util.Collection;
import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);

    }

   public void saveUser(User user) { usersDao.save(user);    }


    public void deleteOfId(int id){
        usersDao.deleteId(id);}

    public Object findOfName(String name){
        usersDao.findByName(name);

        return name;
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }
    public Collection<User> CountUniqueName(String name){
        return usersDao.finduniqueName(name);

    }

}

