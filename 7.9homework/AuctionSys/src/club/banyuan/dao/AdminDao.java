package club.banyuan.dao;

import club.banyuan.entity.Admin;

public interface AdminDao extends IBaseDao{
  public int add(Admin admin);
  public Admin getLoginUser(String userName, String pwd);
}
