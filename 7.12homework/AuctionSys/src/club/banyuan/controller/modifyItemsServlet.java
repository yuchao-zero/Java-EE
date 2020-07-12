package club.banyuan.controller;

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

@WebServlet(name = "modifyItemsServlet", urlPatterns = "/modify.do")
public class modifyItemsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    Items items = new Items();
    items.setId(Integer.valueOf(request.getParameter("id")));
    items.setItemName(request.getParameter("itemName"));
    items.setStartPrice(Long.valueOf(request.getParameter("startPrice")));
    items.setBasePrice(Long.valueOf(request.getParameter("basePrice")));
    items.setStartTime(request.getParameter("startTime"));
    items.setEndTime(request.getParameter("endTime"));
    items.setDescription(request.getParameter("description"));

    try {
      ItemsDaoImpl itemsDao = new ItemsDaoImpl(JdbcUtils.getConnection());
      int modify = itemsDao.modify(items);
      List<Items> itemsList = itemsDao.getItems();

      if (modify > 0) {
        request.setAttribute("itemsList",itemsList);
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
