package club.banyuan.service.impl;

import club.banyuan.entity.UserAddress;
import club.banyuan.service.UserAddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressServiceImpl implements UserAddressService {

  @Autowired
  private UserAddressService userAddressService;
  public List<UserAddress> getAddressByUserId(int userId) {
    return userAddressService.getAddressByUserId(userId);
  }
}
