package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itmonopoly.java01.stock.model.Part;

import java.util.List;

public interface PartRepository extends CrudRepository<Part, Long> {

    @Query("SELECT p FROM Part p LEFT JOIN FETCH p.models m WHERE m.id=:id")
    List<Part> partsModel(@Param("id") Long id);

    // just reference "findBySpec" for method name could be used instead query
    @Query("SELECT p FROM Part p WHERE p.spec=:spec")
    List<Part> findPartBySpec(@Param("spec") String spec);

}
