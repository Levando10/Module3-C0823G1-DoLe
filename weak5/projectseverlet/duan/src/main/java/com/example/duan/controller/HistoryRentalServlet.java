package com.example.duan.controller;

import com.example.duan.model.BangSuDung;
import com.example.duan.service.MayTinhService;
import com.example.duan.service.impl.IMayTinhService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HistoryRentalServlet" , value = "/history-rental-servlet")
public class HistoryRentalServlet extends HttpServlet {
  private IMayTinhService computerService = new MayTinhService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action){
      case "historyRental":
        historyRental(request,response);
        break;
      default:
        historyRental(request,response);

    }


  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }

  private void historyRental(HttpServletRequest request, HttpServletResponse response) {
    int idMay = Integer.parseInt(request.getParameter("id"));
    List<BangSuDung> historyList = computerService.historyRental(idMay);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/View/historyRental.jsp");
    request.setAttribute("historyList",historyList);
    try {
      requestDispatcher.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }
}
