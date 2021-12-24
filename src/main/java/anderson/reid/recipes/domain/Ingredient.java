package anderson.reid.recipes.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
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

   public Ingredient() {}

   public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
      this.description = description;
      this.amount = amount;
      this.uom = uom;
   }

   public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
      this.description = description;
      this.amount = amount;
      this.uom = uom;
      this.recipe = recipe;
   }
}
