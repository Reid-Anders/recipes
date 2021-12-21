package anderson.reid.recipes.controllers;

import anderson.reid.recipes.repositories.RecipeRepository;
import anderson.reid.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

   private final RecipeService recipeService;

   public IndexController(RecipeService recipeService) {
      this.recipeService = recipeService;
   }

   @RequestMapping({"", "/", "index", "index.html"})
   public String getIndexPage(Model model) {
      return "index";
   }
}
