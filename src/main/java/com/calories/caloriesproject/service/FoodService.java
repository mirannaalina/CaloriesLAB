package com.calories.caloriesproject.service;

import com.calories.caloriesproject.persistence.Food;
import com.calories.caloriesproject.persistence.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    //implemented a calculator for calories per day.

    public Integer calculateCalories(List<Food> foodName){
        return foodName.stream().mapToInt(food -> food.getCalorii()).sum();
    }

    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }


}
