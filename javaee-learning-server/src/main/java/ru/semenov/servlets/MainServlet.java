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

public class MainServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(MainServlet.class);
    private static final String PAGE = "main.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Main page");
        req.getRequestDispatcher("WEB-INF/views/" + PAGE).forward(req, resp);
    }
}

