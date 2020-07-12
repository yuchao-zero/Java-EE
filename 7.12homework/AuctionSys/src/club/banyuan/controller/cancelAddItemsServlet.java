package club.banyuan.controller;

import club.banyuan.dao.ItemsDao;
import club.banyuan.dao.imp.ItemsDaoImpl;
import club.banyuan.entity.Items;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理取消增加商品请求
 */
@WebServlet(name = "cancelAddItemsServlet", urlPatterns = "/cancel.do")
public class cancelAddItemsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    ItemsDao itemsDao = null;
    try {
      itemsDao = new ItemsDaoImpl(JdbcUtils.getConnection());
      List<Items> itemsList = itemsDao.getItems();

      //    处理取消
//      String cancel = request.getParameter("cancel");
      request.setAttribute("itemsList", itemsList);
      request.getRequestDispatcher("拍卖商品管理页.jsp").forward(request, response);
    } catch (Exception throwables) {
      throwables.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
