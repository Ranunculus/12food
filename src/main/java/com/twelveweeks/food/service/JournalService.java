package com.twelveweeks.food.service;

import com.twelveweeks.food.controller.requests.JournalRequest;
import com.twelveweeks.food.domain.JournalEntry;
import com.twelveweeks.food.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalService {

    private final JournalRepository repository;

    @Autowired
    public JournalService(JournalRepository repository) {
        this.repository = repository;
    }

    public Iterable<JournalEntry> getAllJournalEntries() {
        return repository.findAll();
    }

    public void addEntry(JournalRequest request) {
        JournalEntry entity = new JournalEntry(request);
        entity.setUserId(1);
        repository.save(entity);
    }
}
