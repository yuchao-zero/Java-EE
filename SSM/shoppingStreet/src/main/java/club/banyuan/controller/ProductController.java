package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

  @Autowired
  private ProductService productService;

  @RequestMapping("/search")
  public String search(String productName, Model model) {
    List<Product> productList = new ArrayList<Product>();
    try {
      productList = productService.getProductByName("%" + productName + "%");
      model.addAttribute("size", productList.size());
      model.addAttribute("productList", productList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "CategoryList";
  }
}
