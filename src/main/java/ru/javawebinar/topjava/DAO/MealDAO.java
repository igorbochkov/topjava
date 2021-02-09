package ru.javawebinar.topjava.DAO;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealDAO {

    List<Meal> getAllMeal();

    Meal getMealById(long id);

    void saveMeal(Meal meal);

    void editMealById(long id, Meal meal);

    Meal deleteMealById(long id);
}
