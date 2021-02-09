package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealService {
    public List<Meal> getListMeal();

    public Meal getMealById(long id);

    public void saveMeal(Meal meal);

    public void editMealById(long id, Meal meal);

    public Meal deleteMealById(long id);
}
