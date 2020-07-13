package club.banyuan.entity;

public class OrderDetail {
  private Integer id;
  private Integer orderId;
  private Integer productId;
  private Integer quantity;
  private double cost;
  private Order order;

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    return "OrderDetail{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", productId=" + productId +
        ", quantity=" + quantity +
        ", cost=" + cost +
        ", order.cost="
        + (order==null?"":order.getCost()) +
        '}';
  }
}
