package ru.semenov.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.servlets.ProductServlet;

import javax.servlet.*;
import java.io.IOException;

public class Utf8Filter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        logger.info("Filter!");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
