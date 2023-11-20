package carrena.orgchart.repository;

import carrena.orgchart.entity.UserDepartmentEntity;
import carrena.orgchart.entity.UserPositionEntity;
import carrena.orgchart.interfaces.UserDepartmentRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserDepartmentRepository extends JpaRepository<UserDepartmentEntity, Long>, UserDepartmentRepositoryInterface {
    public Boolean existsByDepartmentIdentity(String departmentIdentity);
    Optional<UserDepartmentEntity> findByDepartmentIdentity(String departmentIdentity);
}
