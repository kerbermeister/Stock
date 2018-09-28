package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itmonopoly.java01.stock.model.Type;

import java.util.List;

public interface TypeRepository extends CrudRepository<Type, Long> {

    @Query("SELECT t FROM Type t WHERE t.typeName=:typeName")
    List<Type> findTypeByName(@Param("typeName") String typeName);

}
