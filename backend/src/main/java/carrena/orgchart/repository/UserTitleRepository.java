package carrena.orgchart.repository;

import carrena.orgchart.entity.UserTitleEntity;
import carrena.orgchart.interfaces.UserTitleRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTitleRepository extends JpaRepository<UserTitleEntity, Long>, UserTitleRepositoryInterface {
    Boolean existsByTitleIdentity(String titleIdentity);
    Optional<UserTitleEntity> findByTitleIdentity(String titleIdentity);
}
