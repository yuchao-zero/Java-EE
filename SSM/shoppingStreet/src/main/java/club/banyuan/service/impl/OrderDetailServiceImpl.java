package club.banyuan.service.impl;

import club.banyuan.dao.OrderDetailDao;
import club.banyuan.entity.OrderDetail;
import club.banyuan.service.OrderDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

  @Autowired
  private OrderDetailDao orderDetailDao;
  public List<OrderDetail> getOrderDetailByOrderId(int orderId) {
    return orderDetailDao.getOrderDetailByOrderId(orderId);
  }
}
