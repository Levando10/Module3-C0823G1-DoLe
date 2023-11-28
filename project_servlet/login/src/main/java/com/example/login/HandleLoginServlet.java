package com.example.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", value = "/loginHandle")
public class HandleLoginServlet extends HttpServlet {



  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    String argument = req.getParameter("argument");
    String decoded;
    if (argument != null) {
      decoded = URLDecoder.decode(argument, "UTF-8");
    }
    else {
      decoded = "null";
    }

    String user = req.getParameter("user");
    String pass = req.getParameter("password");
      PrintWriter writer = resp.getWriter();
    writer.println("<html>");
    if ("admin".equals(user) && "levando".equals(pass)){
      req.setAttribute("loginTime", new Date());
      RequestDispatcher  requestDispatcher = req.getRequestDispatcher("home.jsp");
      requestDispatcher.forward(req,resp);
    } else {
     resp.sendRedirect("index.jsp");

    }

  }

  @Override
  public void destroy() {
    super.destroy();
  }
}
