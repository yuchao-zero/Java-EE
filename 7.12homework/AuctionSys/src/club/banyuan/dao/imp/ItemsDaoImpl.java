package club.banyuan.dao.imp;

import club.banyuan.dao.ItemsDao;
import club.banyuan.entity.Items;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemsDaoImpl extends BaseDaoImpl implements ItemsDao {

  public ItemsDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public int add(Items items) {
    String sql =
        "insert into auctionItems(itemName,startPrice,basePrice,startTime,endTime,description) "
            + "values(?,?,?,?,?,?)";
    Object[] params = new Object[]{items.getItemName()
        , items.getStartPrice(), items.getBasePrice(), items.getStartTime(), items.getEndTime(),
        items.getDescription()
    };
    int i = executeInsert(sql, params);
    return i;
  }

  @Override
  public List<Items> getItems() throws Exception {
    List<Items> itemsList = new ArrayList<>();
    String sql = "select * from auctionItems";
    ResultSet resultSet = null;
    resultSet = executeQuery(sql);
    while (resultSet.next()) {
      Items items = tableToClass(resultSet);
      itemsList.add(items);
    }
    return itemsList;
  }

  @Override
  public ResultSet executeQuery(String sql) {
    ResultSet rs = null;
    try {
      pstm = connection.prepareStatement(sql);
      rs = pstm.executeQuery();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rs;
  }

  /**
   * 处理多条件查询
   *
   * @param map
   * @return
   * @throws Exception
   */
  @Override
  public List<Items> getItemsByParameter(Map<String, String> map) throws Exception {
    List<Items> itemsList = new ArrayList<>();
    StringBuilder sql = new StringBuilder("select * from auctionItems where 1 = 1");
    String value = null;
    for (String s : map.keySet()) {
      System.out.println("key : " + s + " value : " + map.get(s));
      if (map.get(s) != null && !map.get(s).equals("")) {
        value = map.get(s);
        sql.append(" and ").append(s).append(" = ").append("'").append(map.get(s)).append("'");
      }
    }
    ResultSet resultSet = executeQuery(sql.toString());
    while (resultSet.next()) {
      Items items = tableToClass(resultSet);
      itemsList.add(items);
    }
    return itemsList;
  }

  @Override
  public int modify(Items items) {
    String sql = "update auctionItems set itemName=?, startPrice=?, basePrice=?, "
        + "startTime=?, endTime=?, description=? "
        + "where id = ?";
    Object[] params = new Object[]{
        items.getItemName(),
        items.getStartPrice(),
        items.getBasePrice(),
        items.getStartTime(),
        items.getEndTime(),
        items.getDescription(),
        items.getId()
    };
    int updateRow = 0;
    try {
      updateRow = this.executeUpdate(sql, params);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
    }
    return updateRow;
  }

  @Override
  public int delete(Items items) {
    String sql =
        "delete from auctionItems where id = ?";
    Object[] params = new Object[]{items.getId()
    };
    int i = executeUpdate(sql, params);
    return i;
  }

  @Override
  public Items tableToClass(ResultSet rs) throws Exception {
    Items items = new Items(rs.getInt(1),
        rs.getString(2),
        rs.getLong(3),
        rs.getLong(4),
        rs.getString(5),
        rs.getString(6),
        rs.getString(7)
    );
    return items;
  }
}
