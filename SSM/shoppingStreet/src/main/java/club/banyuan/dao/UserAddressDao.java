package club.banyuan.dao;

import club.banyuan.entity.UserAddress;
import java.util.List;

public interface UserAddressDao {

  public List<UserAddress> getAddressByUserId(int userId);

}
