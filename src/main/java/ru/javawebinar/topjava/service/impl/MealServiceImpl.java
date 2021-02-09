package ru.javawebinar.topjava.service.impl;

import ru.javawebinar.topjava.DAO.MealDAO;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

public class MealServiceImpl implements MealService {

    private MealDAO mealDAO;

    public MealServiceImpl(MealDAO mealDAO) {
        this.mealDAO = mealDAO;
    }

    @Override
    public List<Meal> getListMeal() {
        return mealDAO.getAllMeal();
    }

    @Override
    public Meal getMealById(long id) {
        return mealDAO.getMealById(id);
    }

    @Override
    public void saveMeal(Meal meal) {
        mealDAO.saveMeal(meal);
    }

    @Override
    public void editMealById(long id, Meal meal) {
        mealDAO.editMealById(id, meal);
    }

    @Override
    public Meal deleteMealById(long id) {
        return mealDAO.deleteMealById(id);
    }
}
