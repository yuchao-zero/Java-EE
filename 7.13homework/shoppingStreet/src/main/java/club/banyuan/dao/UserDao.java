package club.banyuan.dao;

import club.banyuan.entity.User;
import java.util.List;

public interface UserDao {

  public List<User> getAll();
  public User findById(int id);
  public int addUser(User user);
  public int updateUser(User user);
  public int deleteUser(int userId);
  public List<User> getUserByName(String name);
}
