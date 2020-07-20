package club.banyuan.service;

import club.banyuan.entity.OrderDetail;
import java.util.List;

public interface OrderDetailService {

  public List<OrderDetail> getOrderDetailByOrderId(int orderId);
}
