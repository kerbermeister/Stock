package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itmonopoly.java01.stock.model.OutcomeItem;

import java.util.List;

public interface OutcomeItemRepository extends CrudRepository<OutcomeItem, Long> {

    @Query("SELECT o.count FROM OutcomeItem o")
    List<Long> getTotalOutcomeItemsQty();

    @Query("SELECT o.count FROM OutcomeItem o WHERE o.part.id=:id")
    List<Long> getPartOutcomeQty(@Param ("id") Long id);
}
