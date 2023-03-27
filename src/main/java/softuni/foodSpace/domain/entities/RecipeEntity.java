package softuni.foodSpace.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import softuni.foodSpace.domain.enums.DifficultyLevel;
import softuni.foodSpace.domain.enums.TypeDishesEnum;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recipes")
public class RecipeEntity extends BaseEntity{

    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficulty;
    @Column(nullable = false, name = "cooking_time")
    private LocalTime cookingTime;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private int portions;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private TypeDishesEnum typeDish;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToMany
    private List<UserEntity> likes;

    public RecipeEntity() {
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public RecipeEntity setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public LocalTime getCookingTime() {
        return cookingTime;
    }

    public RecipeEntity setCookingTime(LocalTime cookingTime) {
        this.cookingTime = cookingTime;
        return this;
    }

    public int getPortions() {
        return portions;
    }

    public RecipeEntity setPortions(int portions) {
        this.portions = portions;
        return this;
    }

    public List<UserEntity> getLikes() {
        return likes;
    }

    public RecipeEntity setLikes(List<UserEntity> likes) {
        this.likes = likes;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public String getName() {
        return name;
    }

    public RecipeEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public RecipeEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public TypeDishesEnum getTypeDish() {
        return typeDish;
    }

    public RecipeEntity setTypeDish(TypeDishesEnum typeDish) {
        this.typeDish = typeDish;
        return this;
    }
}
