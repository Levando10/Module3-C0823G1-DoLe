package com.example.managementproduct.controller;

import com.example.managementproduct.model.Product;
import com.example.managementproduct.service.ProductService;
import com.example.managementproduct.service.ProductServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductController",urlPatterns = "/product-controller")
public class ProductServlet extends HttpServlet {
  private final ProductService productService = new ProductServiceImpl();


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String action = request.getParameter("action");
    System.out.println(action);
    if (action == null) {
      action = "";
    }
    switch (action){
      case "create":
        handleCreateProduct(request,response);
        break;
      case "update":
        handleUpdateProduct(request,response);
        break;
      case "delete":
        handleDeleteProduct(request,response);
        break;
      default:
        break;
    }
  }

  private void handleCreateProduct(HttpServletRequest request, HttpServletResponse response) {
  String id = request.getParameter("id");
  String name = request.getParameter("name");
  Long price = Long.valueOf(request.getParameter("price"));
  String description = request.getParameter("description");
  Product product = new Product(id,name,price,description);
  this.productService.saveProduct(product);
  RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
  request.setAttribute("message","Create Success");
    try {
      requestDispatcher.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void handleDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
    String id = request.getParameter("id");
    this.productService.deleteProduct(id);
    try {
      response.sendRedirect("product-controller");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private void handleUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
      String id = request.getParameter("id");
      String name = request.getParameter("name");
      Long price = Long.valueOf(request.getParameter("price"));
      String description = request.getParameter("description");
      Product product = this.productService.findProductById(id);

      product.setNameProduct(name);
      product.setPrice(price);
      product.setDescription(description);
      this.productService.updateProduct(id,product);
      request.setAttribute("product",product);
      request.setAttribute("message","update sucesss");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/update.jsp");

    try {
      requestDispatcher.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
   String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
   switch (action){
     case "create":
       showCreateProduct(request,response);
       break;
     case "update":
       showUpdateProduct(request,response);
       break;
     case "delete":
       showDeleteProduct(request,response);
       break;
     case "view":
       viewProduct(request,response);
       break;
     default:
       showListProduct(request,response);

   }
  }


  private void viewProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/view.jsp");
    String id = request.getParameter("id");
    Product product = this.productService.findProductById(id);
    request.setAttribute("product",product);
    requestDispatcher.forward(request,response);
  }

  private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
    requestDispatcher.forward(request,response);
  }

  private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    Product product = productService.findProductById(id);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/delete.jsp");
    request.setAttribute("product",product);
    requestDispatcher.forward(request,response);
  }

  private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    request.setCharacterEncoding("UTF-8");
    List<Product> productList = this.productService.listProduct();
    request.setAttribute("productList",productList);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
    requestDispatcher.forward(request,response);

  }

  private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String id = request.getParameter("id");
    String action = request.getParameter("action");
    Product product = this.productService.findProductById(id);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/update.jsp");
    request.setAttribute("product",product);
    requestDispatcher.forward(request,response);
  }

}
