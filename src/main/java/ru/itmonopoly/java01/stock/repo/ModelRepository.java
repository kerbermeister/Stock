package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itmonopoly.java01.stock.model.Model;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Long> {

    List<Model> findAllByType_Id(Long typeId);

    @Query("SELECT m FROM Model m WHERE m.name=:name")
    List<Model> findModelByName(@Param("name") String name);


}
