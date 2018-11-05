package com.twelveweeks.food.domain;

import com.twelveweeks.food.controller.requests.JournalRequest;
import com.twelveweeks.food.domain.enums.NutritionType;
import com.twelveweeks.food.domain.enums.Unit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "JOURNAL")
public class JournalEntry {

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

    @Column(name = "NUTRITION_TYPE")
    @Enumerated(EnumType.STRING)
    protected NutritionType nutritionType;

    @Column(name = "USER_ID")
    protected Integer userId;

    @Column(name = "INTAKE_DATE")
    protected Date date;

    public JournalEntry() {}

    public JournalEntry(JournalRequest request) {
        this.name = request.getName();
        this.unit = request.getUnit();
        this.amount = request.getAmount();
        this.nutritionType = request.getType();
        this.date = request.getDate();
    }
}
