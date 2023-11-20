package carrena.orgchart.repository;

import carrena.orgchart.entity.UserRoleEntity;
import carrena.orgchart.interfaces.UserRoleRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>, UserRoleRepositoryInterface {
    Boolean existsByRoleIdentity(String roleIdentity);
    Optional<UserRoleEntity> findByRoleIdentity(String roleIdentity);
}
