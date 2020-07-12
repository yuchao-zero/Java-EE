package club.banyuan.controller;

import club.banyuan.entity.Items;
import club.banyuan.service.AdminSearchItemsService;
import club.banyuan.service.imp.AdminSearchItemsServiceImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminSearchItemsServlet", urlPatterns = "/adminSearch.do")
public class adminSearchItemsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");

    System.out.println("doPost...");
    String itemName = request.getParameter("itemName");
    String description = request.getParameter("description");
    String startTime = request.getParameter("startTime");
    String endTime = request.getParameter("endTime");
    String startPrice = request.getParameter("startPrice");

    Map<String, String> map = new HashMap<>();
    map.put("itemName", itemName);
    map.put("description", description);
    map.put("startPrice", startPrice);
    map.put("startTime", startTime);
    map.put("endTime", endTime);

    AdminSearchItemsService adminSearchItemsService = new AdminSearchItemsServiceImpl();
    try {
      List<Items> itemsList = adminSearchItemsService.getItemsByParameter(map);
      if (itemsList != null) {
        System.out.println("itemsList is not null");
        request.setAttribute("itemsList", itemsList);
        request.getRequestDispatcher("拍卖商品管理页.jsp").forward(request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
