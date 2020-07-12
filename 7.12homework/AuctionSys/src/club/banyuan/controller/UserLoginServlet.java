package club.banyuan.controller;

import club.banyuan.dao.ItemsDao;
import club.banyuan.dao.imp.ItemsDaoImpl;
import club.banyuan.entity.Items;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.imp.UserServiceImpl;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/login.do")
public class UserLoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
// 通过getParameter拿到submit的值，进行判断进行注册或者登陆跳转
    String regist = request.getParameter("regist");
    System.out.println(regist);
    if (regist != null){
      request.getRequestDispatcher("register.html").forward(request,response);
      return;
    }
    UserService userService = new UserServiceImpl();
    try {
      User user = userService.login(userName, password);
      ItemsDao itemsDao = new ItemsDaoImpl(JdbcUtils.getConnection());
      List<Items> itemsList = itemsDao.getItems();

      if (user != null) {
        request.setAttribute("user", user);
        request.setAttribute("itemsList",itemsList);
        request.getRequestDispatcher("拍卖品列表页.jsp").forward(request, response);
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        return;
      }

    } catch (Exception throwables) {
      throwables.printStackTrace();
    }

    System.out.println("user为null");
    request.getRequestDispatcher("login.html").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
