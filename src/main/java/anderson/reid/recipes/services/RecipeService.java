package anderson.reid.recipes.services;

import anderson.reid.recipes.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface RecipeService {
   Set<Recipe> getRecipes();
}
