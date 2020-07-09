package club.banyuan.dao.imp;

import club.banyuan.dao.ItemsDao;
import club.banyuan.entity.Items;
import java.sql.Connection;
import java.sql.ResultSet;

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
  public Object tableToClass(ResultSet rs) throws Exception {
    Items items = new Items(rs.getInt(1),
        rs.getString(2),
        rs.getInt(3),
        rs.getInt(4),
        rs.getString(5),
        rs.getString(6),
        rs.getString(7)
    );
    return items;
  }
}
