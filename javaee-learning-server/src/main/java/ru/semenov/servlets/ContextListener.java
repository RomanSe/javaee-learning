package ru.semenov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Role;
import ru.semenov.entities.User;
import ru.semenov.repositories.ProductRepository;
import ru.semenov.services.RoleService;
import ru.semenov.services.UserService;

import javax.ejb.EJB;
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

    @EJB
    private UserService userService;

    @EJB
    private RoleService roleService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
//        logger.info("Context intialization:" + context.getContextPath());
//        context.setAttribute("productRepository", productRepository);
//        for (int i = 0; i < 10; i++) {
//            productRepository.insert(new Product("Name " + i, "Description 1", "100.png", i));
//        }
//        logger.info("Products were added");
        final Role userRole = roleService.findByName("USER");
        final Role admin = roleService.findByName("ADMIN");
        User user = new User("user1", "user1", null, null);
        userService.insert(user);
        user.addRole(userRole);
        userService.merge(user);
        User user2 = new User("user2", "user2", null, null);
        user2.setId(1);
        userService.insert(user2);
        user2.addRole(admin);
        userService.merge(user2);
    }
}
