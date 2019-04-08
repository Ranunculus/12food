package com.twelveweeks.food.repository;

import com.twelveweeks.food.domain.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {
}
