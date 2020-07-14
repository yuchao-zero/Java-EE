package club.banyuan.dao;

import club.banyuan.entity.Items;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface ItemsDao{
  public int add(Items items);
  public List<Items> getItems()throws Exception;
  public List<Items> getItemsByParameter(Map<String, String> map) throws Exception;
  public int modify(Items items);
  public int delete(Items items);
}
