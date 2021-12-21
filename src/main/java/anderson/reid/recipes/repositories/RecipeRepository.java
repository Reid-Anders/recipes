package anderson.reid.recipes.repositories;

import anderson.reid.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

//when you create a repository that extends CrudRepository, the spring framework automatically provides an implementation of these interfaces under the hood for you
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
