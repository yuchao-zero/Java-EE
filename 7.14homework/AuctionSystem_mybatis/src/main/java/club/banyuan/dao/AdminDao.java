package club.banyuan.dao;

import club.banyuan.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
  public Admin getLoginUser(@Param("userName") String userName, @Param("password") String password);
}
