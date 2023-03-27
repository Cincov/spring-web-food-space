package softuni.foodSpace.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.foodSpace.domain.entities.UserRoleEntity;
import softuni.foodSpace.domain.enums.UserRoleEnum;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRoleEntity, String> {
    Optional<UserRoleEntity> findByRole(UserRoleEnum role);

}
