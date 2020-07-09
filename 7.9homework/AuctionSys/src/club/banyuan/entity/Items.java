package club.banyuan.entity;

public class Items {

  private Integer id;
  private String itemName;
  private String description;
  private String startTime;
  private String endTime;
  private Integer startPrice;
  private Integer basePrice;

  public Items() {

  }

  public Items(Integer id, String itemName,Integer startPrice, Integer basePrice,  String startTime,
      String endTime,String description) {
    this.id = id;
    this.itemName = itemName;
    this.description = description;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startPrice = startPrice;
    this.basePrice = basePrice;
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

  public Integer getStartPrice() {
    return startPrice;
  }

  public void setStartPrice(Integer startPrice) {
    this.startPrice = startPrice;
  }

  public Integer getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Integer basePrice) {
    this.basePrice = basePrice;
  }
}
