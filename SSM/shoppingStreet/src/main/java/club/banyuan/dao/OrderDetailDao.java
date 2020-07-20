package club.banyuan.dao;

import club.banyuan.entity.OrderDetail;
import java.util.List;

public interface OrderDetailDao {
    public List<OrderDetail> getOrderDetailByOrderId(int orderId);
}
