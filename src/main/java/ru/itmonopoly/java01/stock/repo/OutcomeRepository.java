package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.repository.CrudRepository;
import ru.itmonopoly.java01.stock.model.Outcome;

public interface OutcomeRepository extends CrudRepository<Outcome, Long> {
}
