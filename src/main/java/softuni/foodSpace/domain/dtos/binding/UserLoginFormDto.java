package softuni.foodSpace.domain.dtos.binding;

import softuni.foodSpace.validations.userExists.ValidateLoginUser;

@ValidateLoginUser
public class UserLoginFormDto {
    private String username;
    private String password;

    public UserLoginFormDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginFormDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginFormDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
