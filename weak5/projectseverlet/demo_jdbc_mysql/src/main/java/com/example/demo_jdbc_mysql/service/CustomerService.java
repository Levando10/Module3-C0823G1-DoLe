package com.example.demo_jdbc_mysql.service;

import com.example.demo_jdbc_mysql.model.User;
import com.example.demo_jdbc_mysql.repository.CustomerRepository;
import com.example.demo_jdbc_mysql.repository.ICustomerRepository;
import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService{
  private ICustomerRepository iCustomerRepository = new CustomerRepository();

  @Override
  public List<User> selectAllUsers() {
    return iCustomerRepository.selectAllUsers();
  }

  @Override
  public boolean deleteUser(int id) throws SQLException {
    return iCustomerRepository.deleteUser(id);
  }

  @Override
  public boolean updateUser(User user) throws SQLException {
    return iCustomerRepository.updateUser(user);
  }

  @Override
  public List<User> searchByCountry(String country) {
    return iCustomerRepository.searchByCountry(country);
  }

  @Override
  public List<User> sortByName() {
    return iCustomerRepository.sortByName();
  }

  @Override
  public User getUserByIdStore(int id) {
    return iCustomerRepository.getUserByIdStore(id);
  }

  @Override
  public void insertUserByIdStore(User user) throws SQLException {
    iCustomerRepository.insertUserByIdStore(user);
  }

  @Override
  public void insertUser(User user) throws SQLException {
    iCustomerRepository.insertUser(user);
  }

  @Override
  public User selectUser(int id) {
    return iCustomerRepository.selectUser(id);
  }
}
