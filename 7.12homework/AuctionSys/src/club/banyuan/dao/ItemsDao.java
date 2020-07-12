package club.banyuan.dao;

import club.banyuan.entity.Items;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ItemsDao extends IBaseDao{
  public int add(Items items);
  public List<Items> getItems()throws Exception;
  public ResultSet executeQuery(String sql);
  public List<Items> getItemsByParameter(Map<String,String> map) throws Exception;
  public int modify(Items items);
  public int delete(Items items);
}
