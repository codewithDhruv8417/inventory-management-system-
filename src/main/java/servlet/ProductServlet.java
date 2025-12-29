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
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private InventoryService service;

    @Override
    public void init() {
        service = new InventoryService(new ProductDAO());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Product> products = service.getAllProducts();
            request.setAttribute("products", products);
            request.getRequestDispatcher("products.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Error fetching products", e);
        }
    }
}

