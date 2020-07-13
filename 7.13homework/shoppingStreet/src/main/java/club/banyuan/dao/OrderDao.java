package club.banyuan.dao;

import club.banyuan.entity.Order;
import club.banyuan.vo.OrderAndUser;
import java.util.List;

public interface OrderDao {
    public List<OrderAndUser> findAll();

    public Order findOrderAndDetailById(int id);

    public Order findOrderAndProductById(int id);
}
