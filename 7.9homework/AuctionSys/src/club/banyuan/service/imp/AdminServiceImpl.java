package club.banyuan.service.imp;

import club.banyuan.dao.imp.AdminDaoImpl;
import club.banyuan.entity.Admin;
import club.banyuan.service.AdminService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {

  @Override
  public Admin login(String userName, String password) throws SQLException {
    AdminDaoImpl adminDao = new AdminDaoImpl(JdbcUtils.getConnection());
    return adminDao.getLoginUser(userName,password);
  }
}
