package club.banyuan.test;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.UserAddressDao;
import club.banyuan.entity.UserAddress;
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

public class TestUserAddressDao {

  InputStream ins;
  SqlSession session;
  UserAddressDao userAddressDao;
  @Before
  public void init() throws IOException {
    // 加载配置文件
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
    // 获取用于创建SqlSessionFactory对象的类的对象
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    // 创建SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = builder.build(ins);
    // 创建SqlSession对象
    session = sqlSessionFactory.openSession();
    // 获取接口的实现类对象
    // 动态代理设计模式，获取接口的实现类对象
    userAddressDao = session.getMapper(UserAddressDao.class);
  }

  @Test
  public void testGetAddressByUserId(){
    List<UserAddress> list = userAddressDao.getAddressByUserId(2);
    for (UserAddress u:list
    ) {
      System.out.println(u);
    }
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

}
