package org.ssh.product.service;
 
import org.ssh.product.model.Product;
 
/**
 * 商品操作-服务层接口
 *
 */
public interface ProductService {
     
    void saveProduct(Product product);
    
    void save(Product product);
 
}