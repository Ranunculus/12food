package com.twelveweeks.food.controller;

import com.twelveweeks.food.controller.requests.JournalRequest;
import com.twelveweeks.food.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/journal")
public class JournalController {

    private final JournalService service;

    @Autowired
    public JournalController(JournalService service) {
        this.service = service;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"), true));
    }

    @ModelAttribute
    public void fillModel(Model model) {
        model.addAttribute("journalRequest", new JournalRequest());
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("rows", service.getAllJournalEntries());
        return "journal";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid JournalRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("journalRequest", request);
            model.addAttribute("rows", service.getAllJournalEntries());
            return "journal";
        }
        service.addEntry(request);
        model.addAttribute("rows", service.getAllJournalEntries());
        return "journal";
    }
}
