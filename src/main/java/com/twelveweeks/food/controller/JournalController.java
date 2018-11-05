package com.twelveweeks.food.controller;

import com.twelveweeks.food.controller.requests.JournalRequest;
import com.twelveweeks.food.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class JournalController {

    private final JournalService service;

    @Autowired
    public JournalController(JournalService service) {
        this.service = service;
    }

    @ModelAttribute
    public void fillModel(Model model) {
        model.addAttribute("journalRequest", new JournalRequest());
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("rows", service.getAllJournalEntries());
        return "journal";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid JournalRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("journalRequest", request);
            return "journal";
        }
        service.addEntry(request);
        model.addAttribute("rows", service.getAllJournalEntries());
        return "journal";
    }
}
