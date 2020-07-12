package club.banyuan.service;

import club.banyuan.entity.Items;
import java.util.List;
import java.util.Map;

public interface UserSearchService {
  public List<Items> getItemsByParameter(Map<String, String> map) throws Exception;

}
