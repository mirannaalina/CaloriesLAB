package com.calories.caloriesproject.controller;

import com.calories.caloriesproject.persistence.Food;
import com.calories.caloriesproject.persistence.FoodRepository;
import com.calories.caloriesproject.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/home")
    public String index(Model model){
        List<Food> foods = foodRepository.findAll();
        model.addAttribute("foods",foods);
        model.addAttribute("sumaCalorii",foodService.calculateCalories(foods));
        return "index.html";
    }
    @GetMapping("/add")
    public String addFood(Model model){
        model.addAttribute("food",new Food());
        return "addFood.html";
    }
    @PostMapping("/save")
    public String save(Food food){
        foodRepository.save(food);
        return "redirect:/home";
    }
    @GetMapping("/delete/{id}")
    public String deleteFood(@PathVariable("id")Long foodId, Model model){
        foodRepository.deleteById(foodId);
        return "redirect:/home";

    }

}
