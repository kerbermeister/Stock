package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itmonopoly.java01.stock.model.IncomeItem;

import java.util.List;

public interface IncomeItemRepository extends CrudRepository<IncomeItem, Long> {

    @Query("SELECT i.count FROM IncomeItem i")
    List<Long> getTotalIncomeItemsQty();

    @Query("SELECT i.count FROM IncomeItem i WHERE i.part.id=:id")
    List<Long> getPartIncomeQty(@Param("id") Long id);
}
