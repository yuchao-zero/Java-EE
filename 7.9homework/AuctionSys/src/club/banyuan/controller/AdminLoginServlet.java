package club.banyuan.controller;

import club.banyuan.entity.Admin;
import club.banyuan.service.AdminService;
import club.banyuan.service.imp.AdminServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/adminLogin.do")
public class AdminLoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    AdminService adminService = new AdminServiceImpl();
    try {
      Admin admin = adminService.login(userName, password);

      if (admin != null) {
        request.setAttribute("admin", admin);
        request.getRequestDispatcher("拍卖商品管理页.html").forward(request, response);
        System.out.println(admin.getUserName());
        System.out.println(admin.getPassword());
        return;
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    System.out.println("admin为null");
    request.getRequestDispatcher("adminLogin.html").forward(request, response);
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
