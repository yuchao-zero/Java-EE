package club.banyuan.dao;

import club.banyuan.entity.Product;

public interface ProductDao {
    public Product getProductAndOrder(int productId);
    Product getProductById(Integer id);
}
