package club.banyuan.service.impl;

import club.banyuan.dao.impl.AddressDaoImpl;
import club.banyuan.entity.Address;
import club.banyuan.service.AddressService;
import club.banyuan.util.JdbcUtils;
import java.util.List;

public class AddressServiceImpl implements AddressService {

  @Override
  public List<Address> getAddressbyUserId(int userId) throws Exception {
    AddressDaoImpl addressDao = new AddressDaoImpl(JdbcUtils.getConnection());
    return addressDao.getAddressbyUserId(userId);
  }
}