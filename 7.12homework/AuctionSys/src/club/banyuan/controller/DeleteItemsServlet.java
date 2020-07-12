package club.banyuan.controller;

import club.banyuan.dao.imp.ItemsDaoImpl;
import club.banyuan.entity.Items;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteItemsServlet", urlPatterns = "/delete.do")
public class DeleteItemsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    Items items = new Items();

    System.out.println(request.getParameter("id"));
    items.setId(Integer.valueOf(request.getParameter("id")));

    try {
      ItemsDaoImpl itemsDao = new ItemsDaoImpl(JdbcUtils.getConnection());
      int delete = itemsDao.delete(items);
      List<Items> itemsList = itemsDao.getItems();

      if (delete > 0) {
        request.setAttribute("itemsList", itemsList);
        request.getRequestDispatcher("拍卖商品管理页.jsp").forward(request, response);
        return;
      }
      response.sendRedirect("拍卖商品管理页.jsp");
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
