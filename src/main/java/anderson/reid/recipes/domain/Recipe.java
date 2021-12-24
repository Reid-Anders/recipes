package anderson.reid.recipes.domain;

import anderson.reid.recipes.repositories.RecipeRepository;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String description;
   private Integer prepTime;
   private Integer cookTime;
   private Integer servings;
   private String source;
   private String url;

   @Lob
   private String directions;

   @Lob
   private Byte[] image;

   @OneToOne(cascade = CascadeType.ALL)
   private Notes notes;

   //cascade: changes to this class cascade into other classes
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
   private Set<Ingredient> ingredients = new HashSet<>();

   //ordinal is default for enumtype: will persist difficulty as 1, 2, and 3
   //string stores the enumeration values as strings in the db
   @Enumerated(value = EnumType.STRING)
   private Difficulty difficulty;

   //define the join (bridge table) that will be automatically created in the h2 database. visit /h2-console to see it
   //joined on joincolumns (recipe_id) and from the other class inversejoincolumns (category_id)
   @ManyToMany
   @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
   private Set<Category> categories = new HashSet<>();

   public Recipe addIngredient(Ingredient ingredient) {
      ingredient.setRecipe(this);
      ingredients.add(ingredient);
      return this;
   }
   public void setNotes(Notes notes) {
      notes.setRecipe(this);
      this.notes = notes;
   }
}
