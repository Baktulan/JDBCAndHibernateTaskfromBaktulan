package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createSQLQuery("drop table users").executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully saved");

    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully removed");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public List<User> getAllUsers() {
        List<User>users = new ArrayList<>();
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        users=session.createQuery("select u from User u  ", User.class).getResultList();
        session.getTransaction().commit();
        session.close();

        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createSQLQuery("delete from users").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully cleaned");


    }
}
