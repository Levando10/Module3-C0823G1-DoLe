package com.example.duan.controller;

import com.example.duan.model.BangSuDung;
import com.example.duan.model.MayTinh;
import com.example.duan.model.NhanVien;
import com.example.duan.service.MayTinhService;
import com.example.duan.service.impl.IMayTinhService;
import java.io.IOException;
import java.sql.ResultSet;
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
      case "detail":
        detailComputer(request,response);
        break;
      case "startTime":
        startTime(request,response);
        break;
      case "endTime":
        endTime(request,response);
        break;
      case "dungchitiet":
        detailUsing(request,response);
        break;
//      case "historyRental":
//        historyRental(request,response);
//        break;


      default:
        showListComputer(request, response);
        break;
    }
  }

  private void historyRental(HttpServletRequest request, HttpServletResponse response) {
    int idMay = Integer.parseInt(request.getParameter("id"));
    List<BangSuDung> historyList = computerService.historyRental(idMay);

  }

//  private void areRenting(HttpServletRequest request, HttpServletResponse response) {
//    List<MayTinh> mayTinhList = computerService.getListMayTinh();
//    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/View/mayDangThue.jsp");
//    request.setAttribute("mayDangThue", mayTinhList);
//    try {
//      requestDispatcher.forward(request,response);
//    } catch (ServletException e) {
//      throw new RuntimeException(e);
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }
//
//
//  }

  private void detailUsing(HttpServletRequest request, HttpServletResponse response) {
      int idBangSuDung = Integer.parseInt(request.getParameter("idBangSuDung"));
      int idMayTinh = Integer.parseInt(request.getParameter("idMay"));




  }

  private void endTime(HttpServletRequest request, HttpServletResponse response) {

    int idMay = Integer.parseInt(request.getParameter("idMay"));
    int idBangSuDung = computerService.getIdSuDung(idMay);
    System.out.println(idBangSuDung);
    LocalDateTime end = LocalDateTime.now();
    MayTinh mayTinh = new MayTinh(idMay);
    BangSuDung bangSuDung = new BangSuDung(idBangSuDung,mayTinh,end);
    computerService.endTimeComputer(bangSuDung);
    try {
      response.sendRedirect("/may-dang-thue-servlet");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }

  private void startTime(HttpServletRequest request, HttpServletResponse response) {
    List<MayTinh> mayTinhList = computerService.getListMayTinh();
      int idMay = Integer.parseInt(request.getParameter("idMay"));
      MayTinh mayTinh = new MayTinh(idMay);
    LocalDateTime start = LocalDateTime.now();
    NhanVien nhanVien = new NhanVien(1);
    BangSuDung bangSuDung = new BangSuDung(start,mayTinh,nhanVien);
    int  idBangSuDung =  computerService.startTimeComputer(bangSuDung);


//    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/may-tinh-servlet");
//    request.setAttribute("idBangSuDung",idBangSuDung);
//    request.setAttribute("mayTinhList",mayTinhList);
//    request.setAttribute("idMay",idMay);
    try {
      response.sendRedirect("/may-chua-thue-servlet");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

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
