package carrena.orgchart.repository;

import carrena.orgchart.entity.UserTitleEntity;
import carrena.orgchart.interfaces.UserTitleRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTitleRepository extends JpaRepository<UserTitleEntity, Long>, UserTitleRepositoryInterface {

}
