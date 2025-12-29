<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<html>
<head>
    <title>Products List</title>
    <style>
        body {
            font-family: Arial;
            margin: 40px;
        }
        table {
            border-collapse: collapse;
            width: 80%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>

<body>

<h2>Inventory Products</h2>

<table>
    <tr>
        <th>ID</th>
        <th>SKU</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Reorder Level</th>
    </tr>

    <%
        List<Product> products = (List<Product>) request.getAttribute("products");

        if (products != null) {
            for (Product p : products) {
    %>
    <tr>
        <td><%= p.getProductId() %></td>
        <td><%= p.getSku() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getQuantity() %></td>
        <td><%= p.getReorderLevel() %></td>
    </tr>
    <%
            }
        }
    %>

</table>

</body>
</html>
