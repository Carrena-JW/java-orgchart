package carrena.orgchart.entity;

import carrena.orgchart.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="userDepartment")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDepartmentEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true,name = "department_id")
    private String departmentIdentity;
    private String parentDepartmentIdentity;
    @Column(nullable = false)
    private String name;
    private String departmentManagerIdentity;
    private long sortOrder = 0;
    private Status status = Status.active;

    @Builder
    public UserDepartmentEntity(String departmentIdentity, String parentDepartmentIdentity, String name, String departmentManagerIdentity, long sortOrder, Status status) {
        this.departmentIdentity = departmentIdentity;
        this.parentDepartmentIdentity = parentDepartmentIdentity;
        this.name = name;
        this.departmentManagerIdentity = departmentManagerIdentity;
        this.sortOrder = sortOrder;
        this.status = status;
    }
}
