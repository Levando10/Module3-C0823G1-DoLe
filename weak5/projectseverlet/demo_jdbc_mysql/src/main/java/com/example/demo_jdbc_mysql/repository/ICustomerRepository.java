package com.example.demo_jdbc_mysql.repository;

import com.example.demo_jdbc_mysql.model.User;
import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {

  public void insertUser(User user) throws SQLException;

  public User selectUser(int id);

  public List<User> selectAllUsers();

  public boolean deleteUser(int id) throws SQLException;

  public boolean updateUser(User user) throws SQLException;
}
