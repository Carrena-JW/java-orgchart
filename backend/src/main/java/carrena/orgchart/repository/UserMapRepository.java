package carrena.orgchart.repository;

import carrena.orgchart.entity.UserEntity;
import carrena.orgchart.entity.UserMapEntity;
import carrena.orgchart.interfaces.UserRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserMapRepository extends JpaRepository<UserMapEntity, Long> {

}
