package club.banyuan.entity;

public class News {
  private Integer n_Id;
  private String title;
  private String content;
  private String createTime;

  public News(){

  }

  public News(Integer n_Id, String title, String content, String createTime) {
    this.n_Id = n_Id;
    this.title = title;
    this.content = content;
    this.createTime = createTime;
  }

  public Integer getn_Id() {
    return n_Id;
  }

  public void setn_Id(Integer nId) {
    this.n_Id = nId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "News{" +
        "n_Id=" + n_Id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", createTime='" + createTime + '\'' +
        '}';
  }
}
