package club.banyuan.service.imp;

import club.banyuan.dao.imp.ItemsDaoImpl;
import club.banyuan.entity.Items;
import club.banyuan.service.AdminSearchItemsService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AdminSearchItemsServiceImpl implements AdminSearchItemsService {

  @Override
  public List<Items> getItemsByParameter(Map<String, String> map) throws Exception {
    ItemsDaoImpl itemsDao = new ItemsDaoImpl(JdbcUtils.getConnection());
    return itemsDao.getItemsByParameter(map);
  }
}
