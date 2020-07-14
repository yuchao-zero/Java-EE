package club.banyuan.test;

import club.banyuan.dao.AdminDao;
import club.banyuan.entity.Admin;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAdminDao {

  private InputStream ins;
  private SqlSessionFactory factory;
  private SqlSession session;
  private AdminDao adminDao;

  @Before
//    在测试方法执行执行执行这个函数
  public void init() throws IOException {
//      读取配置文件
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
//      创建构造者对象
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//      创建SQLSession工厂对象
    factory = builder.build(ins);
//      创建SQLSession对象
    session = factory.openSession();
//      创建Dao的代理对象,动态获取接口的实现类对象
    adminDao = session.getMapper(AdminDao.class);
  }

  @Test
  public void testGetLoginUser(){
    Admin admin = adminDao.getLoginUser("管理员1","guanliyuan");
    System.out.println(admin);
  }


  @After
//  在测试方法结束后执行
  public void destroy() throws IOException {
    session.commit();
//      释放资源
    session.close();
    ins.close();
  }

}
