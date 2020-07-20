//package club.banyuan.test;
//
//import club.banyuan.dao.ProductDao;
//import club.banyuan.entity.Order;
//import club.banyuan.entity.Product;
//import java.io.IOException;
//import java.io.InputStream;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class TestProductDao {
//    InputStream ins;
//    SqlSession session;
//    ProductDao productDao;
//    @Before
//    public void init() throws IOException {
//        // 加载配置文件
//        ins = Resources.getResourceAsStream("SqlMapConfig.xml");
//        // 获取用于创建SqlSessionFactory对象的类的对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        // 创建SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = builder.build(ins);
//        // 创建SqlSession对象
//        session = sqlSessionFactory.openSession();
//        // 获取接口的实现类对象
//        // 动态代理设计模式，获取接口的实现类对象
//        productDao = session.getMapper(ProductDao.class);
//    }
//
//    @Test
//    public void getProductById() {
//        Product product = productDao.getProductById(770);
//        System.out.println(product);
//    }
//
//    @After
//    public void destrory() throws IOException {
//        session.commit();
//        session.close();
//        ins.close();
//    }
//
//    @Test
//    public void testGetProductAndOrderById(){
//        Product product = productDao.getProductAndOrder(733);
//        System.out.println(product);
//        for (Order order : product.getOrderList()) {
//            System.out.println(order);
//        }
//    }
//
//}
