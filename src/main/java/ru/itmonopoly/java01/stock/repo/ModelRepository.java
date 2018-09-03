package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.repository.CrudRepository;
import ru.itmonopoly.java01.stock.model.Model;

public interface ModelRepository extends CrudRepository<Model, Long> {
}
