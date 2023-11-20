package carrena.orgchart.repository;

import carrena.orgchart.entity.UserPositionEntity;
import carrena.orgchart.interfaces.UserPositionRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPositionRepository extends JpaRepository<UserPositionEntity, Long>, UserPositionRepositoryInterface {
   Boolean existsByPositionIdentity(String positionIdentity);
   Optional<UserPositionEntity> findByPositionIdentity(String positionIdentity);
}
