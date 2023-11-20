package carrena.orgchart.entity;

import carrena.orgchart.enums.Status;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "userRole")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRoleEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true,name = "role_id")
    private String roleIdentity;
    @Column(nullable = false)
    private String name;
    private Status status = Status.active;
    private long sortOrder = 0;

    @Builder
    public UserRoleEntity(String userRoleIdentity, String name, Status status, long sortOrder) {
        this.name = name;
        this.roleIdentity = userRoleIdentity;
        this.status = status == null ? Status.active : status;;
        this.sortOrder = sortOrder;
    }


}
