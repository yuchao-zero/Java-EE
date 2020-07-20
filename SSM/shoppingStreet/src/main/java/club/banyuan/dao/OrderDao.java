package club.banyuan.dao;

import club.banyuan.entity.Order;
import club.banyuan.vo.OrderAndUser;
import java.util.List;

public interface OrderDao {

    List<Order> getOrderbyUserId(int userId)throws Exception;
}
