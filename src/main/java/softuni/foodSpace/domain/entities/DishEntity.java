package softuni.foodSpace.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import softuni.foodSpace.domain.enums.TypeDishesEnum;

import java.time.LocalTime;

@Entity
@Table(name = "dishes")
public class DishEntity extends BaseEntity{

    private String name;
    private TypeDishesEnum type;
    private String description;


    public String getName() {
        return name;
    }

    public DishEntity setName(String name) {
        this.name = name;
        return this;
    }

    public TypeDishesEnum getType() {
        return type;
    }

    public DishEntity setType(TypeDishesEnum type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DishEntity setDescription(String description) {
        this.description = description;
        return this;
    }

}
