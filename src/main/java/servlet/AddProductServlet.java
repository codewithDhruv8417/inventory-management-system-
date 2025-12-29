package servlet;

import dao.ProductDAO;
import model.Product;
import service.InventoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {

    private InventoryService service;

    @Override
    public void init() {
        service = new InventoryService(new ProductDAO());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String sku = request.getParameter("sku");
            String name = request.getParameter("name");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int reorder = Integer.parseInt(request.getParameter("reorder"));

            // Server-side validation
            if (sku == null || sku.isEmpty() || name == null || name.isEmpty()) {
                throw new Exception("Invalid input");
            }

            Product p = new Product();
            p.setSku(sku);
            p.setName(name);
            p.setQuantity(quantity);
            p.setReorderLevel(reorder);

            service.addProduct(p);

            // Redirect to products page
            response.sendRedirect("products");

        } catch (Exception e) {
            throw new ServletException("Error adding product", e);
        }
    }
}
