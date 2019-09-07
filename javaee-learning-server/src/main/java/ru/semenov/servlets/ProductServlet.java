package ru.semenov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Product;
import ru.semenov.repositories.ProductRepository;
import ru.semenov.services.ProductService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    private static final String PAGE = "product.jsp";

    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Product");
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        if (product == null)
            throw new ServletException("There is no product " + id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("WEB-INF/views/" + PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Product post: #" + req.getParameter("id") + " name = " + req.getParameter("name") + " description="+ req.getParameter("description"));


        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        if (product == null)
            throw new ServletException("There is no product " + id);
        product.setName(req.getParameter("name"));
        product.setDescription(req.getParameter("description"));
        productService.merge(product);

        req.setAttribute("title", "Product");
        req.setAttribute("product", product);
        req.getRequestDispatcher("WEB-INF/views/" + PAGE).forward(req, resp);
    }
}
