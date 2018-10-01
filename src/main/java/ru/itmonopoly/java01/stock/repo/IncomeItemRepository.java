package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itmonopoly.java01.stock.model.IncomeItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IncomeItemRepository extends CrudRepository<IncomeItem, Long> {

    @Query("SELECT i.count FROM IncomeItem i")
    List<Long> getTotalIncomeItemsQty();

    @Query("SELECT i.count FROM IncomeItem i WHERE i.part.id=:id")
    List<Long> getPartIncomeQty(@Param("id") Long id);

    @Query(value = "SELECT inc.part_id, coalesce(inc.count, 0) - coalesce(ord.count, 0) as count from (select part_id, sum(count) as count from income_item group by part_id) inc left join (select part_id, sum(count) as count from outcome_item group by part_id) ord on inc.part_id = ord.part_id" , nativeQuery = true)
    List<Object[]> getPartsQty();
}
