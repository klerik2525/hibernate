package dao;

import models.Auto;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDao implements interfaceDao {




    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);

    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }




    public void deleteId(int id){

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.load(User.class, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    public List<User> findByName(String name) {

Object name1 = null;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery( " from User where name = :name" );
        query.setParameter("name", name1).list();
        List<User> users = (List<User>) query.getResultList();

        return users;

    }



    public Collection<User> finduniqueName(String name){
        Object name1 = name;

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "select count (name) "+"from User where name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name1).list();
        List<User> users = (List<User>) query.getResultList();

        return users;
    }


}
