package club.banyuan.service;

import club.banyuan.entity.Order;
import club.banyuan.vo.OrderAndUser;
import java.util.List;

public interface OrderService {

  List<Order> getOrderbyUserId(int userId)throws Exception;
}
