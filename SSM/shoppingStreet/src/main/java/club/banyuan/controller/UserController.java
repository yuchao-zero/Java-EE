package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/login")
  public String getLoginUser(HttpServletRequest request,String userName ,String pwd){
    HttpSession session = request.getSession();
    User user = userService.getLoginUser(userName,pwd);

    session.setAttribute("user",user);

    return "index";
  }
}
