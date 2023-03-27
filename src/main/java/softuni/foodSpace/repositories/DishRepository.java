package softuni.foodSpace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.foodSpace.domain.entities.DishEntity;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Long> {


}
