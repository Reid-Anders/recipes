package anderson.reid.recipes.repositories;

import anderson.reid.recipes.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

   //query method
   Optional<UnitOfMeasure> findByDescription(String description);
}
