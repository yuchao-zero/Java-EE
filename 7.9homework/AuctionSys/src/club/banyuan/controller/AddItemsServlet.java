package club.banyuan.controller;

import club.banyuan.dao.ItemsDao;
import club.banyuan.dao.imp.ItemsDaoImpl;
import club.banyuan.entity.Items;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员点击发布，进入增加商品界面，add完成后，返回商品管理页面 在管理界面点击修改页面，跳往修改界面，完成后返回商品管理页面
 */
@WebServlet(name = "AddItemsServlet", urlPatterns = "/addItems.do")
public class AddItemsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    Items items = new Items();
    items.setItemName(request.getParameter("itemName"));
    items.setStartPrice(Integer.valueOf(request.getParameter("startPrice")));
    items.setBasePrice(Integer.valueOf(request.getParameter("basePrice")));
    items.setStartTime(request.getParameter("startPrice"));
    items.setEndTime(request.getParameter("endTime"));
    items.setDescription(request.getParameter("description"));

    try {
      ItemsDao itemsDao = new ItemsDaoImpl(JdbcUtils.getConnection());
      int id = itemsDao.add(items);
      if (id > 0) {
        request.getRequestDispatcher("拍卖商品管理页.html").forward(request, response);
        return;
      }
      response.sendRedirect("增加商品页.html");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
