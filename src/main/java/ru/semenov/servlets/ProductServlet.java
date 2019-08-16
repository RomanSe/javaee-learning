package ru.semenov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Product;
import ru.semenov.repositories.ProductRepository;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ProductServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    private static final String PAGE = "product.jsp";

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        productRepository = (ProductRepository) context.getAttribute("productRepository");
        if (productRepository == null) {
            throw new ServletException("No product repository!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Product");
        Integer id = Integer.parseInt(req.getParameter("id"));
        Product product = productRepository.findById(id);
        if (product == null)
            throw new ServletException("There is no product " + id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("WEB-INF/views/" + PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Product post: #" + req.getParameter("id") + " name = " + req.getParameter("name") + " description="+ req.getParameter("description"));


        Integer id = Integer.parseInt(req.getParameter("id"));
        Product product = productRepository.findById(id);
        if (product == null)
            throw new ServletException("There is no product " + id);
        product.setName(req.getParameter("name"));
        product.setDescription(req.getParameter("description"));
        productRepository.update(product);

        req.setAttribute("title", "Product");
        req.setAttribute("product", product);
        req.getRequestDispatcher("WEB-INF/views/" + PAGE).forward(req, resp);
    }
}
