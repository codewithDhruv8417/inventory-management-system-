# Inventory Management System for Small Businesses

A Java-based desktop inventory management system (GUI) that helps small businesses track stock, manage product details, and receive low-stock alerts. Built with Java (Swing/JavaFX), JDBC and MySQL.

## Features
- Add / Update / Delete products (name, SKU, category, quantity, supplier, buy/expiry dates)
- Low-stock alerts (reorder level)
- Simple reports: current inventory and low-stock list
- Export reports to CSV (optional)
- Modular code: DAO pattern, service layer, GUI layer

## Tech Stack
- Java 11+ (or Java 8)
- Swing (or JavaFX) for GUI
- MySQL
- JDBC (PreparedStatement)
- JUnit for unit tests

## Repo Structure
inventory-management/
├── .gitignore
├── README.md
├── pom.xml
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── model/
│       │   │   └── Product.java
│       │   ├── dao/
│       │   │   ├── DBConnection.java
│       │   │   ├── IProductDAO.java
│       │   │   └── ProductDAO.java
│       │   ├── service/
│       │   │   └── InventoryService.java
│       │   └── ui/
│       │       └── MainGUI.java
│       │
│       └── resources/
│           ├── config.properties
│           ├── messages.properties
│           └── icons/
│               ├── add.png
│               ├── edit.png
│               ├── delete.png
│               └── logo.png
│
├── sql/
│   └── schema.sql
│
└── docs/
    └── screenshots/
