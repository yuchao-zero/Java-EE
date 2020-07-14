package club.banyuan.test;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserDao {

  private InputStream ins;
  private SqlSessionFactory factory;
  private SqlSession session;
  private UserDao userDao;

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
    userDao = session.getMapper(UserDao.class);
  }

  @Test
  public void testAddUser() {
    User user = new User();
    user.setUserName("张三疯");
    user.setPassword("123");
    user.setIdOfNumber(12345321L);
    user.setTelNumber(18372375655L);

    int i = userDao.add(user);
    System.out.println(i);
    System.out.println(user.getId());
  }

  @Test
  public void testGetLoginUser(){
    User user = userDao.getLoginUser("张三疯","123");
    System.out.println(user);
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
