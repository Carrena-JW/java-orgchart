package carrena.orgchart.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="userMap")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMap_id")
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="department_id")
    private UserDepartmentEntity department;

    @ManyToOne
    @JoinColumn(name="user_position_id")
    private UserPositionEntity position;

    @ManyToOne
    @JoinColumn(name="user_title_id")
    private UserTitleEntity title;

    @ManyToOne
    @JoinColumn(name="user_role_id")
    private UserRoleEntity role;

}
