package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String sql = " create table if not exists users(" +
                " id serial primary key," +
                "first_name varchar," +
                "last_name varchar," +
                "age int)";
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            System.out.println("Successfully created");
            statement.executeUpdate(sql);
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String sql=" drop table users";
        try{
            Connection connection =Util.getConnection();
            Statement statement=connection.createStatement();
            statement.execute(sql);
            System.out.println("Successfully droped");
            statement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = " insert into users(" +
                "first_name,last_name,age)" +
                "values (?,?,?)";
        try {
            Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Successfully saved");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void removeUserById(long id) {
        String sql = " delete from users where id=?";
        try {
            Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Successfully deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = " select * from users";
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(new User
                        (resultSet.getLong("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getByte("age")));

            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = "delete from users";
        try {
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            System.out.println("Successfully cleaned");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}