package ru.semenov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Product;
import ru.semenov.repositories.ProductRepository;

import javax.faces.annotation.FacesConfig;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@FacesConfig
@WebListener
public class ContextListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Inject
    private ProductRepository productRepository;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        logger.info("Context intialization:" + context.getContextPath());
        context.setAttribute("productRepository", productRepository);
        for (int i = 0; i < 10; i++) {
            productRepository.insert(new Product("Name " + i, "Description 1", "100.png", i));
        }
        logger.info("Products were added");
    }
}
