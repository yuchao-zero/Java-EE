package club.banyuan.entity;

public class ProductCategory {
  private Integer pc_id;
  private String pc_name;
  private Integer parentId;
  private Integer type;

  public ProductCategory(){

  }

  public ProductCategory(Integer pc_id, String pc_name, Integer parentId, Integer type) {
    this.pc_id = pc_id;
    this.pc_name = pc_name;
    this.parentId = parentId;
    this.type = type;
  }

  public Integer getPc_id() {
    return pc_id;
  }

  public void setPc_id(Integer pc_id) {
    this.pc_id = pc_id;
  }

  public String getPc_name() {
    return pc_name;
  }

  public void setPc_name(String pc_name) {
    this.pc_name = pc_name;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}
