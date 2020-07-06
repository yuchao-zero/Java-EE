package club.banyuan.service.impl;

import club.banyuan.dao.impl.OrderDaoImpl;
import club.banyuan.entity.Order;
import club.banyuan.service.OrderServeice;
import club.banyuan.util.JdbcUtils;
import java.util.List;

public class OrderServeiceImpl implements OrderServeice {

  @Override
  public List<Order> getOrderbyUserId(int userId) throws Exception {
    OrderDaoImpl orderDao = new OrderDaoImpl(JdbcUtils.getConnection());
    return orderDao.getOrderbyUserId(userId);
  }
}