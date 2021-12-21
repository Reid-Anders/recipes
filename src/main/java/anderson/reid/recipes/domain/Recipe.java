package anderson.reid.recipes.domain;

import javax.persistence.*;
import java.util.Set;

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
   private String directions;

   @Lob
   private Byte[] image;

   @OneToOne(cascade = CascadeType.ALL)
   private Notes notes;

   //cascade: changes to this class cascade into other classes
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
   private Set<Ingredient> ingredients;

   //ordinal is default for enumtype: will persist difficulty as 1, 2, and 3
   //string stores the enumeration values as strings in the db
   @Enumerated(value = EnumType.STRING)
   private Difficulty difficulty;

   //define the join (bridge table) that will be automatically created in the h2 database. visit /h2-console to see it
   //joined on joincolumns (recipe_id) and from the other class inversejoincolumns (category_id)
   @ManyToMany
   @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
   private Set<Category> categories;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Integer getPrepTime() {
      return prepTime;
   }

   public void setPrepTime(Integer prepTime) {
      this.prepTime = prepTime;
   }

   public Integer getCookTime() {
      return cookTime;
   }

   public void setCookTime(Integer cookTime) {
      this.cookTime = cookTime;
   }

   public Integer getServings() {
      return servings;
   }

   public void setServings(Integer servings) {
      this.servings = servings;
   }

   public String getSource() {
      return source;
   }

   public void setSource(String source) {
      this.source = source;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getDirections() {
      return directions;
   }

   public void setDirections(String directions) {
      this.directions = directions;
   }

   public Byte[] getImage() {
      return image;
   }

   public void setImage(Byte[] image) {
      this.image = image;
   }

   public Notes getNotes() {
      return notes;
   }

   public void setNotes(Notes notes) {
      this.notes = notes;
   }

   public Set<Ingredient> getIngredients() {
      return ingredients;
   }

   public void setIngredients(Set<Ingredient> ingredients) {
      this.ingredients = ingredients;
   }

   public Difficulty getDifficulty() {
      return difficulty;
   }

   public void setDifficulty(Difficulty difficulty) {
      this.difficulty = difficulty;
   }

   public Set<Category> getCategories() {
      return categories;
   }

   public void setCategories(Set<Category> categories) {
      this.categories = categories;
   }
}
