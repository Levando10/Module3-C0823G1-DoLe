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

@WebServlet(name = "SearchProductServlet",value = "/search-product-servlet")
public class SearchProductServlet extends HttpServlet {
  private final ProductService productService = new ProductServiceImpl();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    RequestDispatcher requestDispatcher;
    String name = request.getParameter("search");
    System.out.println(name);

    List<Product> productList = this.productService.searchListProduct(name);

    if (!productList.isEmpty()){
      request.setCharacterEncoding("UTF-8");
      requestDispatcher = request.getRequestDispatcher("product/search_product.jsp");
      request.setAttribute("productList",productList);
      requestDispatcher.forward(request,response);
    } else {
      request.setCharacterEncoding("UTF-8");
      productList = this.productService.listProduct();
      request.setAttribute("productList",productList);
       requestDispatcher = request.getRequestDispatcher("product/list.jsp");
      request.setAttribute("message","Not found product");
      requestDispatcher.forward(request,response);
    }

  }
}
