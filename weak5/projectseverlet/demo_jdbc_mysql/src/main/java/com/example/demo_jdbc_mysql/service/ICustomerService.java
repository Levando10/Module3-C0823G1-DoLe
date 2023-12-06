package com.example.demo_jdbc_mysql.service;

import com.example.demo_jdbc_mysql.model.User;
import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {

  public void insertUser(User user) throws SQLException;

  public User selectUser(int id);

  public List<User> selectAllUsers();

  public boolean deleteUser(int id) throws SQLException;

  public boolean updateUser(User user) throws SQLException;

  List<User> searchByCountry(String country);

  List<User> sortByName();
  User getUserByIdStore(int id);
  void insertUserByIdStore(User user) throws SQLException;
}
