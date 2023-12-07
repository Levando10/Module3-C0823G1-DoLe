package com.example.demo_jdbc_mysql.controller;


import com.example.demo_jdbc_mysql.model.User;
import com.example.demo_jdbc_mysql.service.CustomerService;
import com.example.demo_jdbc_mysql.service.ICustomerService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private ICustomerService iCustomerService = new CustomerService();

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    try {
      switch (action) {
        case "create":
          insertUser(request, response);
          break;
        case "edit":
          updateUser(request, response);
          break;
        case "delete":
//          deleteUser(request,response);
          break;
      }
    } catch (SQLException ex) {
      throw new ServletException(ex);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }

    try {
      switch (action) {
        case "create":
          showNewForm(request, response);
          break;
        case "edit":
          showEditForm(request, response);
          break;
        case "delete":
          showDeleteForm(request, response);
          break;
        case "search":
          searchByCountry(request,response);
          break;
        case "sort":
          sortByName(request,response);
        default:
          listUser(request, response);
          break;
      }
    } catch (SQLException ex) {
      throw new ServletException(ex);
    }
  }

  private void sortByName(HttpServletRequest request, HttpServletResponse response) {
    List<User> listUser = iCustomerService.sortByName();
    RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
    request.setAttribute("listUser",listUser);
    try {
      dispatcher.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private void searchByCountry(HttpServletRequest request, HttpServletResponse response) {
    String country = request.getParameter("search_name");
    List<User> listUser = iCustomerService.searchByCountry(country);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
    request.setAttribute("listUser",listUser);
    try {
      requestDispatcher.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void listUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {

    List<User> listUser = iCustomerService.selectAllUsers();
    request.setAttribute("listUser", listUser);
    RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
    dispatcher.forward(request, response);
  }

  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
    dispatcher.forward(request, response);
  }

  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    User user = iCustomerService.getUserByIdStore(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
    request.setAttribute("user", user);
    dispatcher.forward(request, response);
  }
  private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    try {
      iCustomerService.deleteUser(id);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    try {
      response.sendRedirect("users");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private void insertUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String country = request.getParameter("country");
    User newUser = new User(name, email, country);
    iCustomerService.addUserTransaction(newUser);
    response.sendRedirect("/users");
  }

  private void updateUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String country = request.getParameter("country");

    User book = new User(id, name, email, country);
    iCustomerService.updateUser(book);
   response.sendRedirect("/users");

  }

//  private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//    {
//    int id = Integer.parseInt(request.getParameter("id"));
//      try {
//        iCustomerService.deleteUser(id);
//      } catch (SQLException e) {
//        throw new RuntimeException(e);
//      }
//      try {
//        response.sendRedirect("users");
//      } catch (IOException e) {
//        throw new RuntimeException(e);
//      }
//
//    }
}