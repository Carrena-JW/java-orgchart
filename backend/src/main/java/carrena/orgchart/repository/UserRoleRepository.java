package carrena.orgchart.repository;

import carrena.orgchart.entity.UserRoleEntity;
import carrena.orgchart.interfaces.UserRoleRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>, UserRoleRepositoryInterface {

}
