package anderson.reid.recipes.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String description;
   private BigDecimal amount;

   //retrieved every time from the database on loadup bc of fetchtype = eager
   //no cascades because deleting an ingredient doesn't delete the existent of a uom
   @OneToOne(fetch = FetchType.EAGER)
   private UnitOfMeasure uom;

   //no cascades, bc if we delete an ingredient we don't want to delete the recipe
   @ManyToOne
   private Recipe recipe;

   public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
      this.description = description;
      this.amount = amount;
      this.uom = uom;
      this.recipe = recipe;
   }

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

   public BigDecimal getAmount() {
      return amount;
   }

   public void setAmount(BigDecimal amount) {
      this.amount = amount;
   }

   public Recipe getRecipe() {
      return recipe;
   }

   public void setRecipe(Recipe recipe) {
      this.recipe = recipe;
   }

   public UnitOfMeasure getUom() {
      return uom;
   }

   public void setUom(UnitOfMeasure uom) {
      this.uom = uom;
   }
}
