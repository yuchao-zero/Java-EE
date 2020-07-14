package club.banyuan.test;

import club.banyuan.dao.ItemsDao;
import club.banyuan.entity.Items;
import club.banyuan.entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestItemsDao {

  private InputStream ins;
  private SqlSessionFactory factory;
  private SqlSession session;
  private ItemsDao itemsDao;

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
    itemsDao = session.getMapper(ItemsDao.class);
  }

  @Test
  public void testAddUser() {
    Items items = new Items();
    items.setItemName("九阳神功");
    items.setStartPrice(99998L);
    items.setBasePrice(100000L);
    items.setStartTime("2020-09-09 00:00:00");
    items.setEndTime("2021-09-09 00:00:00");
    items.setDescription("少年，想不想维护宇宙和平？");

    int i = itemsDao.add(items);
    System.out.println(i);
    System.out.println(items.getId());
  }

  @Test
  public void getItems() {
    try {
      List<Items> itemsList = itemsDao.getItems();
      for (Items i : itemsList
      ) {
        System.out.println(i);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testModify(){
    Items items = new Items();
    items.setId(8);
    items.setItemName("仕女图");
    items.setStartPrice(999999L);
    items.setBasePrice(100000L);
    items.setStartTime("2020-09-09 00:00:00");
    items.setEndTime("2021-09-09 00:00:00");
    items.setDescription("珍藏");
    int i = itemsDao.modify(items);
    System.out.println(i);
  }

  @Test
  public void testDelete(){
    Items items = new Items();
    items.setId(11);
    int i = itemsDao.delete(items);
    System.out.println(i);
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
