package club.banyuan.controller;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.imp.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistServlet", urlPatterns = "/regist.do")
public class RegistServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    User user = new User();
    user.setUserName(request.getParameter("userName"));
    user.setPassword(request.getParameter("password"));
    System.out.println(request.getParameter("idOfNumber"));
//    if(request.getParameter("idOfNumber") == null) {
//      user.setIdOfNumber(null);
//    }else{
    user.setIdOfNumber(Long.parseLong(request.getParameter("idOfNumber")));
//    }
//    if(request.getParameter("telNumber") == null) {
//      user.setTelNumber(null);
//    }else{
    user.setTelNumber(Long.parseLong(request.getParameter("telNumber")));
//    }

    try {
      UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
      int id = userDao.add(user);
      if (id > 0) {
//        重定向要二次请求,会产生很多null,要命的Bug
//        response.sendRedirect("竞拍者登录.html");
        request.getRequestDispatcher("竞拍者登录.html").forward(request, response);
        return;
      }
      response.sendRedirect("竞拍者注册页.html");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
