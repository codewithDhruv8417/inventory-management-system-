package service;

import dao.IProductDAO;
import model.Product;

import java.util.List;

public class InventoryService {

    private IProductDAO productDAO;

    // Constructor to inject the DAO dependency
    public InventoryService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    // Add new product
    public boolean addProduct(Product p) throws Exception {
        return productDAO.addProduct(p) > 0;
    }

    // Update an existing product
    public boolean updateProduct(Product p) throws Exception {
        return productDAO.updateProduct(p);
    }

    // Delete a product by ID
    public boolean deleteProduct(int id) throws Exception {
        return productDAO.deleteProduct(id);
    }

    // Get product by ID
    public Product getProductById(int id) throws Exception {
        return productDAO.getProductById(id);
    }

    // Get all products
    public List<Product> getAllProducts() throws Exception {
        return productDAO.getAllProducts();
    }

    // Get low stock items
    public List<Product> getLowStockProducts() throws Exception {
        return productDAO.getLowStockProducts();
    }
}
