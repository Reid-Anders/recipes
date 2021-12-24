package anderson.reid.recipes.controllers;

import anderson.reid.recipes.domain.Recipe;
import anderson.reid.recipes.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

   @Mock
   RecipeService recipeService;

   @Mock
   Model model;

   IndexController indexController;

   @BeforeEach
   public void setup() throws Exception {
      MockitoAnnotations.initMocks(this);
      indexController = new IndexController(recipeService);
   }

   //creates a mock servlet context to test controllers rather than bringing out the entire spring context... much faster
   @Test
   public void testMockMVC() throws Exception {
      MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
      mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
   }

   @Test
   void getIndexPage() throws Exception {

      //argument capture
      //given
      Set<Recipe> recipes = new HashSet<>();

      Recipe recipe = new Recipe();
      recipe.setId(1L);
      recipes.add(recipe);
      recipes.add(new Recipe());
      when(recipeService.getRecipes()).thenReturn(recipes);

      ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

      //when
      String viewName = indexController.getIndexPage(model);

      //then
      assertEquals("index", viewName);
      verify(recipeService, times(1)).getRecipes();
      verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
      Set<Recipe> setInController = argumentCaptor.getValue();
      assertEquals(2, setInController.size());
   }
}