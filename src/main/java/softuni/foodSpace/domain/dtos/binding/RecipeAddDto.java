package softuni.foodSpace.domain.dtos.binding;

import softuni.foodSpace.domain.enums.DifficultyLevel;
import softuni.foodSpace.domain.enums.TypeDishesEnum;
import java.time.LocalTime;

public class RecipeAddDto {

    private String name;
    private String difficulty;
    private String imageUrl;
    private int portions;
    private String description;
    private TypeDishesEnum typeDish;
    private LocalTime cookingTime;

    public String getName() {
        return name;
    }

    public RecipeAddDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public RecipeAddDto setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeAddDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getPortions() {
        return portions;
    }

    public RecipeAddDto setPortions(int portions) {
        this.portions = portions;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeAddDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public TypeDishesEnum getTypeDish() {
        return typeDish;
    }

    public RecipeAddDto setTypeDish(TypeDishesEnum typeDish) {
        this.typeDish = typeDish;
        return this;
    }

    public LocalTime getCookingTime() {
        return cookingTime;
    }

    public RecipeAddDto setCookingTime(LocalTime cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }
}
