package com.calories.caloriesproject.service;

import com.calories.caloriesproject.persistence.Food;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class FoodService {


    //implemented a calculator for calories per day.

    public Integer calculateCalories(List<Food> foodName){
        return foodName.stream().mapToInt(food -> food.getCalorii()).sum();
    }


}
