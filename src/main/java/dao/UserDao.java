package dao;

import models.Auto;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.postgresql.core.NativeQuery;
import utils.HibernateSessionFactoryUtil;

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

   /* public NativeQuery findUsersAuto(User user) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createSQLQuery("SELECT p.id, p.name , ps.id, ps.model" +
                "FROM users " +
                "INNER JOIN autos ps ON ps.user_id = p.id");

       /* String sql = "SELECT p.id, p.name , ps.id, ps.model" +
                "FROM users " +
                "INNER JOIN autos ps ON ps.user_id = p.id";
        Query query = (Query) session.createSQLQuery(sql);

        tx1.commit();
        session.close();*/


    // }


     /*   Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "select a.id, a.name, b.model "+"from User as a  join Auto as b where name = :name  ";
        Query query = session.createQuery(hql);
        query.setParameter("name", name).list();
        List<User> users = (List<User>) query.getResultList();
        return users;*/


       /* Object name1 = name;

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "SELECT a.id, a.name   from User as a where name = :name " ;

        Query query = session.createQuery(hql);

        query.setParameter("name", name1 ).list();

        List<User> users = (List<User>) query.getResultList();


        return users;*/


    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<Auto> findAllCars() {
        List<Auto> auto = (List<Auto>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Auto").list();
        return auto;
    }




    public Query findUsersAuto() {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String sql = "\"SELECT p.id, p.name , ps.id, ps.model\" +\n" +
                "                        \"FROM users \" +\n" +
                "                        \"INNER JOIN autos ps ON ps.user_id = p.id\"";
        Query query = (Query) session.createSQLQuery(sql)
                .addEntity("id", User.class)
                .addEntity("name", User.class)
                .addEntity("id", Auto.class)
                .addEntity("model", Auto.class);


        return query;
    }

}