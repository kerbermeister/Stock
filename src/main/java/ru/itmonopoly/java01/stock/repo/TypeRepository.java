package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.repository.CrudRepository;
import ru.itmonopoly.java01.stock.model.Type;

public interface TypeRepository extends CrudRepository<Type, Long> {
}
