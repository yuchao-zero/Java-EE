package club.banyuan.test;

import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.entity.Product;
import club.banyuan.vo.OrderAndUser;
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

public class TestOrderDao {
    InputStream ins;
    SqlSession session;
    OrderDao orderDao;
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
        orderDao = session.getMapper(OrderDao.class);
    }

    @After
    public void destrory() throws IOException {
        session.commit();
        session.close();
        ins.close();
    }

    @Test
    public void testFindAll(){
        List<OrderAndUser> orderAndUserList =orderDao.findAll();
        for (int i = 0; i < orderAndUserList.size(); i++) {
            System.out.println(orderAndUserList.get(i));
        }
    }

    @Test
    public void testFindOrderAndDetailById(){
        Order order = orderDao.findOrderAndDetailById(1);
        System.out.println(order);
        System.out.println(order.getOrderDetailList().size());
        for (OrderDetail orderDetail : order.getOrderDetailList()) {
            System.out.println(orderDetail);
        }
    }

    @Test
    public void testFindOrderAndProductById(){
        Order order = orderDao.findOrderAndProductById(1);
        System.out.println(order);
        for (Product product : order.getProductList()) {
            System.out.println(product);
        }
    }
}
