package club.banyuan.dao;

import club.banyuan.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

  public int add(User user);
  public User getLoginUser(@Param("loginName") String loginName,@Param("pwd") String pwd);
}
