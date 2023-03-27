package softuni.foodSpace.domain.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email; // –  username of the user.

    @Column(nullable = false)
    private String password; //– password of the user.

    @Column(nullable = false)
    private String firstName; //–  first name of the user.

    @Column(nullable = false)
    private String lastName; //–  last name of the user.

    @Column(nullable = false, unique = true)
    private String username; //–  last name of the user.

    @Column
    private Boolean isActive; //– true OR false.

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
        name = "users_roles",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private List<UserRoleEntity> roles;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "users_recipes",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "recipe_id") }
    )
    private List<RecipeEntity> likesRecipe;

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public UserEntity setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public List<RecipeEntity> getLikesRecipe() {
        return likesRecipe;
    }

    public UserEntity setLikesRecipe(List<RecipeEntity> likesRecipe) {
        this.likesRecipe = likesRecipe;
        return this;
    }
}