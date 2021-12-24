package anderson.reid.recipes.repositories;

import anderson.reid.recipes.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//integration test (integrated with the spring context)
@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

   @Autowired
   UnitOfMeasureRepository unitOfMeasureRepository;

   @BeforeEach
   void setUp() {
   }

   @Test
   //dirties context will force the context to reload
   //@DirtiesContext
   void findByDescriptionTeaspoon() {
      Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
      assertEquals("Teaspoon", uomOptional.get().getDescription());
   }

   //spring context only gets loaded once, so the second test takes place much faster than the first
   @Test
   void findByDescriptionCup() {
      Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
      assertEquals("Cup", uomOptional.get().getDescription());
   }
}