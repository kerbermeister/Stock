package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.repository.CrudRepository;
import ru.itmonopoly.java01.stock.model.Part;

public interface PartRepository extends CrudRepository<Part, Long> {

}
