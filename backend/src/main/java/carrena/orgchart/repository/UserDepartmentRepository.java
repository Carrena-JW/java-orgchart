package carrena.orgchart.repository;

import carrena.orgchart.entity.UserDepartmentEntity;
import carrena.orgchart.interfaces.UserDepartmentRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDepartmentRepository extends JpaRepository<UserDepartmentEntity, Long>, UserDepartmentRepositoryInterface {

}
