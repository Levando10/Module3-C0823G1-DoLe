package com.example.ss10_list_customer.repository;

import com.example.ss10_list_customer.model.Customer;
import java.util.List;

public interface ICustomerRepository {

  List<Customer> getAllCustomer();
}
