package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    @Override
    public int addProduct(Product p) throws Exception {

        String sql = "INSERT INTO product (sku, name, category_id, supplier_id, quantity, reorder_level, buy_price, sell_price, expiry_date) " +
                     "VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getSku());
            ps.setString(2, p.getName());
            ps.setInt(3, p.getCategoryId());
            ps.setInt(4, p.getSupplierId());
            ps.setInt(5, p.getQuantity());
            ps.setInt(6, p.getReorderLevel());
            ps.setDouble(7, p.getBuyPrice());
            ps.setDouble(8, p.getSellPrice());

            if (p.getExpiryDate() != null) {
                ps.setDate(9, new java.sql.Date(p.getExpiryDate().getTime()));
            } else {
                ps.setNull(9, Types.DATE);
            }

            ps.executeUpdate();

            // Get auto-generated primary key
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        }

        return -1;
    }

    @Override
    public boolean updateProduct(Product p) throws Exception {

        String sql = "UPDATE product SET sku=?, name=?, category_id=?, supplier_id=?, quantity=?, reorder_level=?, buy_price=?, sell_price=?, expiry_date=? " +
                     "WHERE product_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getSku());
            ps.setString(2, p.getName());
            ps.setInt(3, p.getCategoryId());
            ps.setInt(4, p.getSupplierId());
            ps.setInt(5, p.getQuantity());
            ps.setInt(6, p.getReorderLevel());
            ps.setDouble(7, p.getBuyPrice());
            ps.setDouble(8, p.getSellPrice());

            if (p.getExpiryDate() != null) {
                ps.setDate(9, new java.sql.Date(p.getExpiryDate().getTime()));
            } else {
                ps.setNull(9, Types.DATE);
            }

            ps.setInt(10, p.getProductId());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteProduct(int id) throws Exception {

        String sql = "DELETE FROM product WHERE product_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Product getProductById(int id) throws Exception {

        String sql = "SELECT * FROM product WHERE product_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractProduct(rs);
            }
        }

        return null;
    }

    @Override
    public List<Product> getAllProducts() throws Exception {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        }

        return list;
    }

    @Override
    public List<Product> getLowStockProducts() throws Exception {

        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE quantity <= reorder_level";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        }

        return list;
    }

    // ======================================
    // Helper method to convert ResultSet → Product Object
    // ======================================
    private Product extractProduct(ResultSet rs) throws Exception {

        Product p = new Product();

        p.setProductId(rs.getInt("product_id"));
        p.setSku(rs.getString("sku"));
        p.setName(rs.getString("name"));
        p.setCategoryId(rs.getInt("category_id"));
        p.setSupplierId(rs.getInt("supplier_id"));
        p.setQuantity(rs.getInt("quantity"));
        p.setReorderLevel(rs.getInt("reorder_level"));
        p.setBuyPrice(rs.getDouble("buy_price"));
        p.setSellPrice(rs.getDouble("sell_price"));
        p.setExpiryDate(rs.getDate("expiry_date"));

        return p;
    }
}
