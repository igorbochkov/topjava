package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.DAO.Impl.MealDAOImpl;
import ru.javawebinar.topjava.DAO.MealDAO;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.impl.MealServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.slf4j.LoggerFactory.getLogger;

public class UpdateMealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    MealDAO mealDAO = new MealDAOImpl();
    MealService mealService = new MealServiceImpl(mealDAO);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id").trim();

        String data = req.getParameter("data");
        String description = req.getParameter("description");
        String calories = req.getParameter("calories");

        String replace = data.replace("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(replace, formatter);

        Meal meal = new Meal(Long.parseLong(id), localDateTime, description, Integer.valueOf(calories));
        log.debug(id);

        mealService.editMealById(Long.parseLong(id), meal);
        resp.sendRedirect("meals");
//        req.getRequestDispatcher("/meals").forward(req, resp);
    }
}
