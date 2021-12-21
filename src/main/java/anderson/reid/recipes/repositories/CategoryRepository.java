package anderson.reid.recipes.repositories;

import anderson.reid.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

   //query method
   Optional<Category> findByDescription(String description);
}
