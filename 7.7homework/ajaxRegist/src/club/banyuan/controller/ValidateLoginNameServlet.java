package club.banyuan.controller;

import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidateLoginNameServlet")
public class ValidateLoginNameServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String result = "true";
    String loginName = request.getParameter("loginName");
    try {
      Connection connection = JdbcUtils.getConnection();
      String url = "select count(*) from user where loginName = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(url);
      String flag = request.getParameter("loginName");
      preparedStatement.setString(1,flag);
      ResultSet resultSet = preparedStatement.executeQuery();
      if(resultSet.next()){
        result = "false";
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    PrintWriter writer = response.getWriter();
    writer.print(result);
    writer.flush();
    writer.close();
  }



  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
