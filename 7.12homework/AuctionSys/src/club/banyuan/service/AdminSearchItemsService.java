package club.banyuan.service;

import club.banyuan.entity.Items;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AdminSearchItemsService {

  public List<Items> getItemsByParameter(Map<String, String> map) throws Exception;
}
