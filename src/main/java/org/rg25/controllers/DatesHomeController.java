package org.rg25.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rg25.entity.Date;
import org.rg25.entity.Note;
import org.rg25.entity.User;
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
        urlPatterns = {"/dates"}
)
public class DatesHomeController extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<User> userDao = new GenericDao<>(User.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        // No user, default to error page
        if (session.getAttribute("user") == null) {
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/error.jsp");
            dispatch.forward(req, resp);
            return;
        }

        //FIXME
        user = userDao.getById(user.getId());

        List<Date> dateList = user.getDates();

        String url = "/datesHome.jsp";
        req.setAttribute("dates", dateList);
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher(url);
        dispatch.forward(req, resp);
    }
    }
