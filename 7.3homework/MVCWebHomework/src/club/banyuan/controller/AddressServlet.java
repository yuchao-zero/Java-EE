package club.banyuan.controller;

import club.banyuan.entity.Address;
import club.banyuan.entity.Order;
import club.banyuan.entity.User;
import club.banyuan.service.impl.AddressServiceImpl;
import club.banyuan.service.impl.OrderServeiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddressServlet",urlPatterns = "/address.do")
public class AddressServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    List<Address> addressList = null;
    HttpSession session = request.getSession();
    User user = (User)session.getAttribute("user");
    AddressServiceImpl addressService = new AddressServiceImpl();
    try {
      addressList = addressService.getAddressbyUserId(user.getId());
    } catch (Exception e) {
      e.printStackTrace();
    }

    if( addressList != null){
      session.setAttribute("addressList",addressList);
      request.getRequestDispatcher("Member_Address.jsp").forward(request,response);
      return;
    }
    response.sendRedirect("index.jsp");
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);
  }
}