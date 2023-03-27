package softuni.foodSpace.web;

import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import softuni.foodSpace.domain.dtos.binding.RecipeAddDto;
import softuni.foodSpace.domain.dtos.veiw.RecipeViewDto;
import softuni.foodSpace.domain.entities.UserEntity;
import softuni.foodSpace.services.RecipeService;

import java.util.UUID;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ModelAttribute(name = "recipeAddDto")
    public RecipeAddDto recipeAddDto() {
        return new RecipeAddDto();
    }

    @GetMapping("/add")
    public String addRecipe() {

        return "add-recipe";
    }

    @PostMapping("/add")
    public String addRecipeConfirm(@Valid @ModelAttribute RecipeAddDto recipeAddDto, BindingResult bindingResult,
                            @AuthenticationPrincipal UserDetails principal){
        if(bindingResult.hasErrors()){
            return "index";
        }
        String currentUserUsername = principal.getUsername();
        recipeService.addRecipe(recipeAddDto, currentUserUsername);
        return "redirect:/home";
    }



    @GetMapping("/details/{id}")
    public String getRecipeById(@PathVariable("id") Long recipeId,  Model model) {

       RecipeViewDto recipeViewDto = recipeService.findById(recipeId);
        model.addAttribute("recipeDetails", recipeViewDto);
         return "details";
    }

    @PostMapping("/details/{id}")
    public String likeRecipe(@PathVariable("id") Long recipeId, @AuthenticationPrincipal UserDetails principal) {
        String currentUserUsername = principal.getUsername();
        recipeService.likeRecipe(recipeId, currentUserUsername);

        return "details";
    }

    @GetMapping("/all")
    public String getAllRecipes(Model model) {

        var allRecipesPage = recipeService.getAllRecipes();

        model.addAttribute("recipes", allRecipesPage);

        return "recipes";
    }

    @GetMapping("/myRecipes")
    public String getUserRecipes(Model model, @AuthenticationPrincipal UserDetails principal) {

        String currentUserUsername = principal.getUsername();
        var allUserRecipes = recipeService.getAllUserRecipes(currentUserUsername);
        model.addAttribute("userRecipes", allUserRecipes);

        return "my-recipes";
    }

}