package model;

import java.util.Date;

public class Product {

    private int productId;
    private String sku;
    private String name;
    private int categoryId;
    private int supplierId;
    private int quantity;
    private int reorderLevel;
    private double buyPrice;
    private double sellPrice;
    private Date expiryDate;

    // Default Constructor
    public Product() {}

    // Full Constructor
    public Product(int productId, String sku, String name, int categoryId, int supplierId,
                   int quantity, int reorderLevel, double buyPrice, double sellPrice, Date expiryDate) {

        this.productId = productId;
        this.sku = sku;
        this.name = name;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.expiryDate = expiryDate;
    }

    // ===========================
    // Getters & Setters
    // ===========================

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // ===========================
    // toString() for debugging
    // ===========================

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                ", quantity=" + quantity +
                ", reorderLevel=" + reorderLevel +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
