package com.calories.caloriesproject.service;

import com.calories.caloriesproject.persistence.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {



    //to implement a calculator for calories per day.

    public Integer calculateCalories(List<Food> foodName){
        return foodName.stream().mapToInt(food -> food.getCalorii()).sum();
    }
}
