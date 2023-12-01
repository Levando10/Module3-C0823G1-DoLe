package com.example.calculator;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculatorServlet", value = "/calculator-servlet")
public class CalculatorServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {


    String result = null;
      double numOne = Double.parseDouble(req.getParameter("firstNum"));
      double numSecond = Double.parseDouble(req.getParameter("secondNum"));
      String operator = req.getParameter("cal");


      switch (operator){
        case "+" :
          result = String.valueOf(numOne + numSecond);
          break;
        case "-" :
          result = String.valueOf(numOne - numSecond);
          break;
        case "*":
          result = String.valueOf(numOne * numSecond);
          break;
        case "/":
          if (numSecond == 0){
            result = "Không được chia cho 0!!!";
          } else {
            result = String.valueOf(numOne / numSecond);
          }
      }



    RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
    req.setAttribute("result",result);
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
