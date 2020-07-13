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
  public void getAll() {
    List<User> users = userDao.getAll();
    for (User user : users) {
      System.out.println(user);
    }
  }

  @Test
  public void getUserById() {
    User user = userDao.findById(22);
    System.out.println(user);
  }

  @Test
  public void testAddUser() {
    User user = new User();
    user.setLoginName("yy");
    user.setPassword("123");
    user.setUserName("zxz");
    user.setSex(1);
    user.setMobile("1234678");
    user.setEmail("sdf@dfs.com");

    int i = userDao.addUser(user);
    System.out.println(i);
    System.out.println(user.getId());
  }

  @Test
  public void testUpdateUser() {
    User user = new User();
    user.setId(20);
    user.setLoginName("yy");
    user.setSex(1);
    user.setMobile("1234678");
    user.setEmail("sdf@dfs.com");

    user.setUserName("aabbccdd");
    user.setPassword("098");

    int i = userDao.updateUser(user);
    System.out.println(i);
  }

  @Test
  public void testDeleteUser() {
    int i = userDao.deleteUser(20);
    System.out.println(i);
  }

//  模糊查询
  @Test
  public void testGetUserByName(){
    List<User> users = userDao.getUserByName("%李%");
//    List<User> users = userDao.getUserByName("李");
    for (User u:users
    ) {
      System.out.println(u);
    }
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
