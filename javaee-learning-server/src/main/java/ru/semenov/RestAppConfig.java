package ru.semenov;

import io.swagger.jaxrs.config.BeanConfig;
import ru.semenov.rs.ProductRS;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestAppConfig extends Application {

    @Inject
    private ServletContext servletContext;

    public RestAppConfig() {
        init();
    }

    private void init() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath(servletContext.getContextPath());
        beanConfig.setResourcePackage(ProductRS.class.getPackage().getName());
        beanConfig.setTitle("Swagger sample");
        beanConfig.setDescription("Swagger sample");
    }
}
