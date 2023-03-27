package softuni.foodSpace.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.foodSpace.domain.dtos.binding.UserRegisterFormDto;
import softuni.foodSpace.services.EmailService;
import softuni.foodSpace.services.UserService;

@Controller
@RequestMapping("/users")
public class RegistrationController {

  private static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
  private final UserService userService;
  private EmailService emailService;

  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/register")
  public String getRegister() {
    return "auth-register";
  }

  @PostMapping("/register")
  public String postRegister(
      @Valid UserRegisterFormDto userRegisterForm,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes
          .addFlashAttribute("userRegisterForm", userRegisterForm)
          .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

      return "redirect:/users/register";
    }

    userService.registerUser(userRegisterForm);

    return "redirect:/users/login";
  }



  // Model attributes

  @ModelAttribute(name = "userRegisterForm")
  public UserRegisterFormDto initUserRegisterFormDto() {
    return new UserRegisterFormDto();
  }

}
