package com.twelveweeks.food.controller;

import com.twelveweeks.food.controller.requests.FoodRequest;
import com.twelveweeks.food.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/food")
public class FoodController {

    private final FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("rows", service.getAllFood());
        return "journal";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid FoodRequest request, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("journalRequest", request);
//            model.addAttribute("rows", service.getAllJournalEntries());
//            return "journal";
//        }
        service.addFood(request);
        return "food";
    }
}
