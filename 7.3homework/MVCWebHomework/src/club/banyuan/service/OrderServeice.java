package club.banyuan.service;

import club.banyuan.entity.Order;
import java.util.List;

public interface OrderServeice {
  List<Order> getOrderbyUserId(int userId) throws Exception;
}