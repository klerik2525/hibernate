package dao;

import models.Auto;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.postgresql.core.NativeQuery;
import utils.HibernateSessionFactoryUtil;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao implements interfaceDao {


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

    public void deleteId(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.load(User.class, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public List<User> findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "SELECT name" + " From User where name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name).list();
        List<User> users = (List<User>) query.getResultList();
        return users;
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    public List<User> finduniqueName(String name) {
        Object name1 = name;

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "select count (name) " + "from User where name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name1).list();
        List<User> users = (List<User>) query.getResultList();
        return users;
    }



    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<Auto> findAllCars() {
        List<Auto> auto = (List<Auto>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Auto").list();
        return auto;
    }




    /*public Query findUsersAuto() {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String sql = "\"SELECT p.id, p.name , ps.id, ps.model\" +\n" +
                "                        \"FROM users \" +\n" +
                "                        \"INNER JOIN autos ps ON ps.user_id = p.id\"";
        Query query = (Query) session.createSQLQuery(sql);
        List l = query.list();
        Iterator it = l.iterator();
        while (it.hasNext()){
            Object rows[] = (Object[])it.next();
            System.out.println(rows[0]+ "--"+rows[1]+ "--" +rows[3]+ "--" );
        }*/






}