package com.twelveweeks.food.controller.requests;

import com.twelveweeks.food.domain.enums.NutritionType;
import com.twelveweeks.food.domain.enums.Unit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter

@ToString
public class JournalRequest {

    @NotNull
    private String name;

    @NotNull
    @Min(0)
    private BigDecimal amount;

    @NotNull
    private Unit unit;

    @NotNull
    private NutritionType type;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd") // TODO: 5/11/18 chenge to pattern with time 
    @Past
    private Date date;

    public JournalRequest() {}

}
