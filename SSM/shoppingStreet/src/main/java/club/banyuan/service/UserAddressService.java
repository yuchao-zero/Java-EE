package club.banyuan.service;

import club.banyuan.entity.UserAddress;
import java.util.List;

public interface UserAddressService {

  public List<UserAddress> getAddressByUserId(int userId);
}
