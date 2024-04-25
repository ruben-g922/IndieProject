package org.rg25.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rg25.entity.*;
import org.rg25.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/home"}
)
public class HomeController extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<Note> noteDao = new GenericDao<>(Note.class);
    GenericDao<Todo> todoDao = new GenericDao<>(Todo.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // No user, default to timeout page
        //TODO user check show up often, put in separate util class
        if (session.getAttribute("user") == null) {
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/error.jsp");
            dispatch.forward(req, resp);
            return;
        }

        logger.debug(session.getAttribute("user") + " This is the user");

        List<Note> noteList = noteDao.getAll();


        logger.debug("Current notes: " + noteList);
        req.setAttribute("notes", noteList);
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/dashboard.jsp");
        dispatch.forward(req, resp);


    }
    }