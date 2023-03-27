package softuni.foodSpace.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.foodSpace.domain.entities.UserActivationLinkEntity;

@Repository
public interface UserActivationLinkEntityRepository extends JpaRepository<UserActivationLinkEntity, Long> {

}
