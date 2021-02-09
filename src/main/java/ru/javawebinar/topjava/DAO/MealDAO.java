package ru.javawebinar.topjava.DAO;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collections;
import java.util.List;

public class MealDAO {
    List<Meal> mealList = null;

    public MealDAO() {
        mealList = Collections.synchronizedList(MealsUtil.getMeals());
    }

    public List<Meal> getAllMeal() {
        return mealList;
    }

    public Meal getMealById(long id) {
        return mealList.get(Math.toIntExact(id));
    }

    public void saveMeal(Meal meal) {
        mealList.add(meal);
    }

    public void editMealById(long id, Meal meal) {
        mealList.add(Math.toIntExact(id), meal);
    }

    public Meal deleteMealById(long id) {
        return mealList.remove(Math.toIntExact(id));
    }
}



