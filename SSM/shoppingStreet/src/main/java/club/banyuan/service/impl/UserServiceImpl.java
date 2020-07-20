package club.banyuan.service.impl;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserService userService;

  public int add(User user) {
    return userService.add(user);
  }

  public User getLoginUser(String loginName, String pwd) {
    return userService.getLoginUser(loginName, pwd);
  }
}
