package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.DAO.Impl.MealDAOImpl;
import ru.javawebinar.topjava.DAO.MealDAO;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.impl.MealServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class DeleteMealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    MealDAO mealDAO = new MealDAOImpl();
    MealService mealService = new MealServiceImpl(mealDAO);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        log.debug("Delete Meal which id: " + id);

        mealService.deleteMealById(Long.parseLong(id));

        req.getRequestDispatcher("/meals").forward(req, resp);
    }
}
