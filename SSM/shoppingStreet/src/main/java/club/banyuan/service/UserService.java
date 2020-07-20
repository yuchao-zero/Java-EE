package club.banyuan.service;

import club.banyuan.entity.User;

public interface UserService {

  public int add(User user);
  public User getLoginUser(String loginName,String pwd);
}
