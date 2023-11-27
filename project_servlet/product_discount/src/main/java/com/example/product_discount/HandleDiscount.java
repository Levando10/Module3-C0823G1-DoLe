package com.example.product_discount;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "handleDiscountServlet", urlPatterns = "/handleDiscount")
public class HandleDiscount extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    String argument = req.getParameter("argument");
    String decoded;
    if (argument != null) {
      decoded = URLDecoder.decode(argument, "UTF-8");
    }
    else {
      decoded = "null";
    }
    String nameProduct = req.getParameter("productDescription");
    long price = Long.parseLong(req.getParameter("price"));
    long percent = Long.parseLong(req.getParameter("percent"));
    long discountAmount = (long) (price * percent * 0.01);

    PrintWriter writer = resp.getWriter();
    writer.println("<html>");
    writer.println("<h1>Tên của sản phẩm : " + nameProduct + "</h1>");
    writer.println("<h1>Lượng chiết khấu : " + discountAmount + " VND" + "</h1>");
    writer.println("<h1>Giá sau khi đã được chiết khấu : " + (price + discountAmount) + " VND"+ "</h1>");
    writer.println("</html>");


  }



  @Override
  public void destroy() {
    super.destroy();
  }

  @Override
  public void init() throws ServletException {
    super.init();
  }
}
