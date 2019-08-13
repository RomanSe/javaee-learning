package ru.semenov.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class CatalogServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CatalogServlet.class);
    private static final String PAGE = "catalog.html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getServletContext().getResourceAsStream(PAGE)));
        resp.getWriter().print(reader.lines().collect(Collectors.joining()));
    }
}
