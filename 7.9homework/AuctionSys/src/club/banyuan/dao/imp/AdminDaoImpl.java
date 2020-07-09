package club.banyuan.dao.imp;

import club.banyuan.dao.AdminDao;
import club.banyuan.entity.Admin;
import java.sql.Connection;
import java.sql.ResultSet;

public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {

  public AdminDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public int add(Admin admin) {
    String sql = "insert into admin(userName,password) values(?,?)";
    Object[] params = new Object[]{admin.getUserName()
        , admin.getPassword()};
    int i = executeInsert(sql, params);
    return i;
  }

  @Override
  public Admin getLoginUser(String userName, String pwd) {
    String sql = "select * from admin where userName=? and password=?";
    ResultSet rs = executeQuery(sql, new Object[]{userName, pwd});
    Admin admin = null;
    try {
      if (rs.next()) {
        admin = tableToClass(rs);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return admin;
  }

  @Override
  public Admin tableToClass(ResultSet rs) throws Exception {
    Admin admin = new Admin(rs.getInt(1),rs.getString(2),
        rs.getString(3));
    return admin;
  }
}
