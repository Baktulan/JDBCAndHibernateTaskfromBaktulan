package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        UserServiceImpl userService = new UserServiceImpl();
//        userDaoHibernate.saveUser("Januzak","Anashov",(byte) 24);
//        userDaoHibernate.dropUsersTable();
//        userDaoHibernate.removeUserById(5L);
//        System.out.println(userDaoHibernate.getAllUsers());
//        userDaoHibernate.cleanUsersTable();





//        Util.getConnection();
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Baktulan","Nazirbek uulu",(byte) 23);
//        userService.removeUserById(1L);
//        userService.getAllUsers().forEach(System.out::println);
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
