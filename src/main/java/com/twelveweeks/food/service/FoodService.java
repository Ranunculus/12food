package com.twelveweeks.food.service;

import com.twelveweeks.food.controller.requests.FoodRequest;
import com.twelveweeks.food.domain.Food;
import com.twelveweeks.food.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository repository;

    public FoodService(FoodRepository foodRepository) {
        this.repository = foodRepository;
    }

    public Iterable<Food> getAllFood() {
        return repository.findAll();
    }

    public void addFood(FoodRequest request) {
        Food entity = new Food(request);
        repository.save(entity);
    }

}
