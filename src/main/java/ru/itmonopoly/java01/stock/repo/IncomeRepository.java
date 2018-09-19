package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.repository.CrudRepository;
import ru.itmonopoly.java01.stock.model.Income;

public interface IncomeRepository extends CrudRepository<Income, Long> {
}
