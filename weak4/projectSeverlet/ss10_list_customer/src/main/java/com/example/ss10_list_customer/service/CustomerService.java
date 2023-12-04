package com.example.ss10_list_customer.service;

import com.example.ss10_list_customer.model.Customer;
import com.example.ss10_list_customer.repository.CustomerRepository;
import com.example.ss10_list_customer.repository.ICustomerRepository;
import java.util.List;

public class CustomerService implements ICustomerService{
  private ICustomerRepository iCustomerRepository = new CustomerRepository();
  @Override
  public List<Customer> getAllCustomer() {
    return iCustomerRepository.getAllCustomer();
  }
}
