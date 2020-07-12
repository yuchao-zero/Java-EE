package club.banyuan.service.imp;

import club.banyuan.dao.imp.ItemsDaoImpl;
import club.banyuan.entity.Items;
import club.banyuan.service.UserSearchService;
import club.banyuan.util.JdbcUtils;
import java.util.List;
import java.util.Map;

public class UserSearchServiceImpl implements UserSearchService {

  @Override
  public List<Items> getItemsByParameter(Map<String, String> map) throws Exception {
    ItemsDaoImpl itemsDao = new ItemsDaoImpl(JdbcUtils.getConnection());
    return itemsDao.getItemsByParameter(map);
  }
}
