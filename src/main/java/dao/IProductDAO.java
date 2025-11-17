package dao;

import java.util.List;
import model.Product;

public interface IProductDAO {

    // Create
    int addProduct(Product p) throws Exception;

    // Update
    boolean updateProduct(Product p) throws Exception;

    // Delete
    boolean deleteProduct(int productId) throws Exception;

    // Read Single
    Product getProductById(int id) throws Exception;

    // Read All
    List<Product> getAllProducts() throws Exception;

    // Read Low-Stock Items
    List<Product> getLowStockProducts() throws Exception;
}
