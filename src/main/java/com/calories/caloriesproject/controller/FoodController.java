package com.calories.caloriesproject.controller;


import com.calories.caloriesproject.persistence.Food;
import com.calories.caloriesproject.persistence.FoodRepository;
import com.calories.caloriesproject.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/home")
    public String index(Model model){
        List<Food> foods = foodService.getAllFood();
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

    @GetMapping("/download")
    public void downloadfile(HttpServletRequest request,
                                           HttpServletResponse response){
       String dataDirectory = request.getServletContext().getRealPath("/Users/mirannaalina/Downloads");
       Path file = Paths.get(dataDirectory);
       if(Files.exists(file))
           response.setContentType("application/pdf");
       response.addHeader("Content-Disposition","attachment");
       try{
           Files.copy(file,response.getOutputStream());
           response.getOutputStream().flush();
       }catch(IOException e){
           e.printStackTrace();
        }

    }

}
