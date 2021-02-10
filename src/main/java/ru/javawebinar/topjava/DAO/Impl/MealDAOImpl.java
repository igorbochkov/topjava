package ru.javawebinar.topjava.DAO.Impl;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collections;
import java.util.List;

public class MealDAOImpl implements ru.javawebinar.topjava.DAO.MealDAO {
    List<Meal> mealList = null;

    public MealDAOImpl() {
        mealList = Collections.synchronizedList(MealsUtil.getMeals());
    }

    @Override
    public List<Meal> getAllMeal() {
        return mealList;
    }

    @Override
    public Meal getMealById(long id) {
        return mealList.stream().filter(meal -> meal.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void saveMeal(Meal meal) {
        mealList.add(meal);
    }

    @Override
    public void editMealById(long id, Meal meal) {

        Meal mealIndex = mealList.stream().filter(meals -> meals.getId() == id).findFirst().orElse(null);
        mealList.set(mealList.indexOf(mealIndex),meal);
    }

    @Override
    public Meal deleteMealById(long id) {
       Meal mealIndex= mealList.stream().filter(meal -> meal.getId()==id).findFirst().orElse(null);
        return mealList.remove(mealList.indexOf(mealIndex));
    }
}



