package club.banyuan.entity;

public class UserAddress {
  private Integer ua_id;
  private Integer userId;
  private String address;
  private String createTime;
  private String remark;

  public UserAddress(){

  }

  public UserAddress(Integer ua_id, Integer userId, String address, String createTime,
      String remark) {
    this.ua_id = ua_id;
    this.userId = userId;
    this.address = address;
    this.createTime = createTime;
    this.remark = remark;
  }

  public Integer getUa_id() {
    return ua_id;
  }

  public void setUa_id(Integer ua_id) {
    this.ua_id = ua_id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "UserAddress{" +
        "ua_id=" + ua_id +
        ", userId=" + userId +
        ", address='" + address + '\'' +
        ", createTime='" + createTime + '\'' +
        ", remark='" + remark + '\'' +
        '}';
  }
}
