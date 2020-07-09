package club.banyuan.service;

import club.banyuan.entity.Admin;
import java.sql.SQLException;

public interface AdminService {
  public Admin login(String userName, String password) throws SQLException;

}
