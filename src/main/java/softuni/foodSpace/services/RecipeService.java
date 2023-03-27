package softuni.foodSpace.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.foodSpace.domain.dtos.binding.RecipeAddDto;
import softuni.foodSpace.domain.dtos.veiw.RecipeViewDto;
import softuni.foodSpace.domain.entities.RecipeEntity;
import softuni.foodSpace.domain.entities.UserEntity;
import softuni.foodSpace.repositories.DishRepository;
import softuni.foodSpace.repositories.RecipeRepository;
import softuni.foodSpace.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final DishRepository dishRepository;
    private final ModelMapper modelMapper;

    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository, DishRepository dishRepository, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.dishRepository = dishRepository;
        this.modelMapper = modelMapper;
    }


    public List<RecipeViewDto> getAllRecipes() {

        List<RecipeViewDto> collect = recipeRepository.findAll().stream()
                .map(this::mapRecipe).collect(Collectors.toList());
        return collect;
    }

    public List<RecipeViewDto> getAllUserRecipes(String currentUserUsername) {
        Optional<UserEntity> currentUser = userRepository.findByEmail(currentUserUsername);
        return recipeRepository.findAllByUser_Id(currentUser.get().getId()).stream()
                .map(this::mapRecipe).collect(Collectors.toList());
    }

    public void addRecipe(RecipeAddDto recipeAddDto, String currentUserUsername) {

        RecipeEntity recipeEntity = modelMapper.map(recipeAddDto, RecipeEntity.class);
        Optional<UserEntity> byUsername = userRepository.findByEmail(currentUserUsername);
        recipeEntity.setUser(modelMapper.map(byUsername, UserEntity.class));

        recipeRepository.save(recipeEntity);
    }

    public RecipeViewDto findById(Long recipeId) {

        RecipeViewDto recipeViewDto = mapRecipe(recipeRepository.findById(recipeId).orElse(null));
        return recipeViewDto;

    }


    public void likeRecipe(Long recipeId, String currentUserUsername) {

        UserEntity user = userRepository.findByEmail(currentUserUsername).orElse(null);
        RecipeEntity recipeEntity = recipeRepository.findById(recipeId).orElse(null);
        List<RecipeEntity> recipeList = user.getLikesRecipe();
        List<UserEntity> userEntityList = recipeEntity.getLikes();
        userEntityList.add(user);
        recipeList.add(recipeEntity);
        user.setLikesRecipe(recipeList);
        recipeEntity.setLikes(userEntityList);

    }

    private RecipeViewDto mapRecipe(RecipeEntity recipeEntity) {
        RecipeViewDto recipeViewDto = new RecipeViewDto();
        recipeViewDto.setName(recipeEntity.getName())
                .setId(recipeEntity.getId())
                .setLikes(recipeEntity.getLikes().size())
                .setPortions(recipeEntity.getPortions())
                .setDescription(recipeEntity.getDescription())
                .setDifficulty(recipeEntity.getDifficulty())
                .setImageUrl(recipeEntity.getImageUrl())
                .setTypeDish(recipeEntity.getTypeDish())
                .setCookingTime(recipeEntity.getCookingTime());
        return recipeViewDto;
    }


}