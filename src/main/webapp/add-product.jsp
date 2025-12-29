<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

<h2>Add New Product</h2>

<form action="add-product" method="post">

    SKU: <input type="text" name="sku" required /><br><br>
    Name: <input type="text" name="name" required /><br><br>
    Quantity: <input type="number" name="quantity" required /><br><br>
    Reorder Level: <input type="number" name="reorder" required /><br><br>

    <input type="submit" value="Add Product" />

</form>

<br>
<a href="products">Back to Products</a>

</body>
</html>
