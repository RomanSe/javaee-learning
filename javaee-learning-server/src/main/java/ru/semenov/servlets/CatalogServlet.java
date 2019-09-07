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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CatalogServlet.class);
    private static final String PAGE = "catalog.jsp";

    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Catalog");
        List<Product> products = productService.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("WEB-INF/views/" + PAGE).forward(req, resp);
    }
}
