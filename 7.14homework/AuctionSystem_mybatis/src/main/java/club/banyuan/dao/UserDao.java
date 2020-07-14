package club.banyuan.dao;

import club.banyuan.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

  public int add(User user);

  public User getLoginUser(@Param("userName") String userName, @Param("password") String password);
}
