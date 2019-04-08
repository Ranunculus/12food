package com.twelveweeks.food.domain;

import com.twelveweeks.food.controller.requests.FoodRequest;
import com.twelveweeks.food.domain.enums.Unit;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data

@Entity
@Table(name = "FOOD")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FOOD_NAME")
    private String name;

    @Column(name = "FOOD_UNIT")
    @Enumerated(EnumType.STRING)
    private Unit unit;

    @Column(name = "FOOD_AMOUNT")
    private BigDecimal amount;

    @Column(name = "CALORIES")
    private BigDecimal calories;

    public Food(FoodRequest request) {
        this.name = request.getName();
        this.unit = request.getUnit();
        this.amount = request.getAmount();
        this.calories = request.getCalories();
    }

}
