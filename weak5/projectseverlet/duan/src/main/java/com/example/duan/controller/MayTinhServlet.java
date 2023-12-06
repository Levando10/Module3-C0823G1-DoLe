package com.example.duan.controller;

import com.example.duan.model.BangSuDung;
import com.example.duan.model.MayTinh;
import com.example.duan.model.NhanVien;
import com.example.duan.service.MayTinhService;
import com.example.duan.service.impl.IMayTinhService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MayTinhServlet" , urlPatterns = "/may-tinh-servlet")
public class MayTinhServlet extends HttpServlet {
  private IMayTinhService computerService = new MayTinhService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "create":
        break;
      case "detail":
        detailComputer(request,response);
        break;
      case "startTime":
        startTime(request,response);
        break;
      default:
        showListComputer(request, response);
    }
  }

  private void startTime(HttpServletRequest request, HttpServletResponse response) {
      int idMay = Integer.parseInt(request.getParameter("idMay"));
      MayTinh mayTinh = new MayTinh(idMay);
    LocalDateTime start = LocalDateTime.now();
    NhanVien nhanVien = new NhanVien(1);
    BangSuDung bangSuDung = new BangSuDung(start,mayTinh,nhanVien);
    computerService.startTimeCompany(bangSuDung);
      //LocalDateTime start = LocalDateTime.now();
    //// Thực hiện một số công việc...
    //LocalDateTime end = LocalDateTime.now();
    //
    //Duration duration = Duration.between(start, end);
    //long minutes = duration.toMinutes();
  }

  private void detailComputer(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
     MayTinh computer = computerService.getComputer(id);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/View/detail.jsp");
    request.setAttribute("computer",computer);
    try {
      requestDispatcher.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)  {

  }

  protected void showListComputer(HttpServletRequest request, HttpServletResponse response) {
    List<MayTinh> mayTinhList = computerService.getListMayTinh();

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/View/home.jsp");
    request.setAttribute("mayTinhList", mayTinhList);
    try {
      requestDispatcher.forward(request, response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
