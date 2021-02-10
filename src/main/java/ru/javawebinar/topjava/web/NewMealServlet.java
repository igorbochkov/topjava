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

public class NewMealServlet extends HttpServlet {
    private static final Logger log = getLogger(NewMealServlet.class);

    MealDAO mealDAO = new MealDAOImpl();
    MealService mealService = new MealServiceImpl(mealDAO);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("in NewMealServlet doGet");

        String data = req.getParameter("data");
        String description = req.getParameter("description");
        String calories = req.getParameter("calories");

        String replace = data.replace("T", " ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(replace, formatter);

        Meal meal = new Meal(localDateTime, description, Integer.valueOf(calories));

        mealService.saveMeal(meal);

//        req.getRequestDispatcher("/meals").forward(req, resp);
        resp.sendRedirect("meals");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.debug("in NewMealServlet doPost");
//        req.getRequestDispatcher("/meals").forward(req, resp);
        resp.sendRedirect("meals");
    }
}
