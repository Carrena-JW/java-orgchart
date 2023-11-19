package carrena.orgchart.repository;

import carrena.orgchart.entity.UserEntity;
import carrena.orgchart.interfaces.UserRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryInterface {

}
