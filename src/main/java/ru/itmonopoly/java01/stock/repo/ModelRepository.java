package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.repository.CrudRepository;
import ru.itmonopoly.java01.stock.model.Model;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Long> {

    List<Model> findAllByType_Id(Long typeId);

}
