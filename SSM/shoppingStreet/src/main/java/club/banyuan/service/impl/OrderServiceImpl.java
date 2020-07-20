package club.banyuan.service.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;
import club.banyuan.service.OrderService;
import club.banyuan.vo.OrderAndUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao order;

  public List<Order> getOrderbyUserId(int userId) throws Exception {
    return order.getOrderbyUserId(userId);
  }
}
