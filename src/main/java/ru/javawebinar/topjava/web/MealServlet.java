package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.DAO.MealDAO;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.impl.MealServiceImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MealDAO mealDAO = new MealDAO();
        MealService mealService = new MealServiceImpl(mealDAO);

        List<MealTo> mealsTo = MealsUtil.filteredByStreamsNoTime(mealService.getListMeal(), MealsUtil.CALORIES_PER_DAY);
        log.debug("create List<MealTo>");

        req.setAttribute("mealsTo", mealsTo);
        log.debug("forward to /meals.jsp");
        req.getRequestDispatcher("/meals.jsp").forward(req, resp);
    }
}
