//package club.banyuan.controller;
//
//import club.banyuan.entity.Product;
//import club.banyuan.service.imp.SearchServiceImpl;
//import java.io.IOException;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "SearchServlet",urlPatterns = "/search.do")
//public class SearchServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String proName = request.getParameter("proName");
//        SearchServiceImpl searchService = new SearchServiceImpl();
//        request.setCharacterEncoding("utf-8");
//        try {
//            List<Product> productList = searchService.getProductByName(proName);
//            if (productList != null) {
//                request.setAttribute("sum",productList.size());
//                request.setAttribute("productList", productList);
//                request.getRequestDispatcher("CategoryList.jsp").forward(request, response);
//            }
//        } catch (Exception throwables) {
//            throwables.printStackTrace();
//        }
//    }
//        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
//        ServletException, IOException {
//            doPost(request, response);
//        }
//}