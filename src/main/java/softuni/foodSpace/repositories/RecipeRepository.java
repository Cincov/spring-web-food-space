package softuni.foodSpace.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.foodSpace.domain.entities.RecipeEntity;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

    @Override
    List<RecipeEntity> findAll();
    List<RecipeEntity> findAllByUser_Id(Long id);
}