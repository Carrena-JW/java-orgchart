package carrena.orgchart.entity;

import carrena.orgchart.enums.Status;
import jakarta.persistence.*;
import lombok.*;


@Entity(name="userTitle")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTitleEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,unique = true,name = "user_title_id")
    private String userTitleIdentity;
    @Column(nullable = false)
    private String name;
    private Status status = Status.active;
    private long sortOrder = 0;


    @Builder
    public UserTitleEntity(String userTitleIdentity, String name, Status status, long sortOrder) {
        this.name = name;
        this.userTitleIdentity = userTitleIdentity;
        this.status = status == null ? Status.active : status;
        this.sortOrder = sortOrder;
    }
}
