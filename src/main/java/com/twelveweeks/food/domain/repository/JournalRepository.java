package com.twelveweeks.food.domain.repository;

import com.twelveweeks.food.domain.JournalEntry;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<JournalEntry, Integer> {
}
