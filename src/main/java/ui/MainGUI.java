package ui;

import dao.ProductDAO;
import model.Product;
import service.InventoryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainGUI extends JFrame {

    private InventoryService service;

    private JTable table;
    private DefaultTableModel tableModel;

    public MainGUI() {

        // Initialize service using ProductDAO
        service = new InventoryService(new ProductDAO());

        // Frame setup
        setTitle("Inventory Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center window

        // Title label
        JLabel title = new JLabel("Inventory Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        // Table setup
        String[] columns = {"ID", "SKU", "Name", "Quantity", "Reorder Level"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        // Buttons
        JButton btnAdd = new JButton("Add Product");
        JButton btnUpdate = new JButton("Update Product");
        JButton btnDelete = new JButton("Delete Product");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        // Layout
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load data into table
        loadProducts();

        setVisible(true);
    }

    // ================================
    // Load products into table
    // ================================
    private void loadProducts() {
        try {
            List<Product> products = service.getAllProducts();
            tableModel.setRowCount(0); // clear old data

            for (Product p : products) {
                tableModel.addRow(new Object[]{
                        p.getProductId(),
                        p.getSku(),
                        p.getName(),
                        p.getQuantity(),
                        p.getReorderLevel()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading products: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ================================
    // MAIN METHOD
    // ================================
    public static void main(String[] args) {
        new MainGUI();
    }
}
