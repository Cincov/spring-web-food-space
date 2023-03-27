package softuni.foodSpace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.foodSpace.services.UserRoleService;
import softuni.foodSpace.services.UserService;

// annotation -> userRegisterFrom -> Validator password.equals(confirmPassword) true false

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    private final UserRoleService roleService;
    private final UserService userService;

    @Autowired
    public UserController(UserRoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

  }
