package com.twelveweeks.food.controller.requests;

import com.twelveweeks.food.domain.enums.Unit;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodRequest {

    private String name;
    private Unit unit;
    private BigDecimal amount;
    private BigDecimal calories;
}
