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

import static org.slf4j.LoggerFactory.getLogger;

public class PrepareToUpdateMealServlet extends HttpServlet {
    private static final Logger log = getLogger(PrepareToUpdateMealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MealDAO mealDAO = new MealDAOImpl();
        MealService mealService = new MealServiceImpl(mealDAO);

        String id = req.getParameter("id");

        Meal meal = mealService.getMealById(Long.parseLong(id));
        LocalDateTime localDateTime = meal.getDateTime();
        String description = meal.getDescription();
        int calories = meal.getCalories();

        req.setAttribute("localDateTime", localDateTime);
        req.setAttribute("description", description);
        req.setAttribute("calories", calories);
        req.setAttribute("id", id);

        req.getRequestDispatcher("/update.jsp").forward(req, resp);

    }
}
