package club.banyuan.entity;

public class Items {

  private Integer id;
  private String itemName;
  private Long startPrice;
  private Long basePrice;
  private String startTime;
  private String endTime;
  private String description;


  public Items() {

  }

  public Items(Integer id, String itemName,Long startPrice, Long basePrice,  String startTime,
      String endTime,String description) {
    this.id = id;
    this.itemName = itemName;
    this.startPrice = startPrice;
    this.basePrice = basePrice;
    this.startTime = startTime;
    this.endTime = endTime;
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Long getStartPrice() {
    return startPrice;
  }

  public void setStartPrice(Long startPrice) {
    this.startPrice = startPrice;
  }

  public Long getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Long basePrice) {
    this.basePrice = basePrice;
  }

  @Override
  public String toString() {
    return "Items{" +
        "id=" + id +
        ", itemName='" + itemName + '\'' +
        ", startPrice=" + startPrice +
        ", basePrice=" + basePrice +
        ", startTime='" + startTime + '\'' +
        ", endTime='" + endTime + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
