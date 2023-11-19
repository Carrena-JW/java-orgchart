package carrena.orgchart.repository;

import carrena.orgchart.entity.UserPositionEntity;
import carrena.orgchart.interfaces.UserPositionRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPositionRepository extends JpaRepository<UserPositionEntity, Long>, UserPositionRepositoryInterface {

}
