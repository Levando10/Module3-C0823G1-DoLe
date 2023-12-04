package com.example.ss10_list_customer.controller;

import com.example.ss10_list_customer.model.Customer;
import com.example.ss10_list_customer.service.CustomerService;
import com.example.ss10_list_customer.service.ICustomerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerServlet" , value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
  private ICustomerService iCustomerService = new CustomerService();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Customer> customerList = iCustomerService.getAllCustomer();
    req.setAttribute("customerList",customerList);
    req.getRequestDispatcher("listCustomer.jsp").forward(req,resp);

  }


}
