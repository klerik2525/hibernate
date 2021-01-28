package services;

import dao.UserDao;
import models.Auto;
import models.User;
import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public void saveUser(User user) { usersDao.save(user); }

    public void updateUser(User user) { usersDao.update(user); }

    public void deleteOfId(int id){ usersDao.deleteId(id);}


    public User findUser(int id) { return usersDao.findById(id); }

    public List<User> findOfName(String name){ return usersDao.findByName(name); }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public List<User> CountUniqueName(String name){ return usersDao.finduniqueName(name); }


    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }
    public List<Auto> findAllAuto() {
        return usersDao.findAllCars();
    }

}

