package softuni.foodSpace.domain.dtos.veiw;

import softuni.foodSpace.domain.enums.DifficultyLevel;
import softuni.foodSpace.domain.enums.TypeDishesEnum;

import java.time.LocalTime;

public class RecipeViewDto {

    private Long id;
    private String name;
    private DifficultyLevel difficulty;
    private LocalTime cookingTime;
    private String imageUrl;
    private int portions;
    private String description;
    private TypeDishesEnum typeDish;
    private int likes;

    public RecipeViewDto() {
    }


    public String getName() {
        return name;
    }

    public RecipeViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public RecipeViewDto setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public LocalTime getCookingTime() {
        return cookingTime;
    }

    public RecipeViewDto setCookingTime(LocalTime cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeViewDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getPortions() {
        return portions;
    }

    public RecipeViewDto setPortions(int portions) {
        this.portions = portions;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeViewDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public TypeDishesEnum getTypeDish() {
        return typeDish;
    }

    public RecipeViewDto setTypeDish(TypeDishesEnum typeDish) {
        this.typeDish = typeDish;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public RecipeViewDto setLikes(int likes) {
        this.likes = likes;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RecipeViewDto setId(Long id) {
        this.id = id;
        return this;
    }
}
