package carrena.orgchart.entity;

import carrena.orgchart.enums.Status;
import jakarta.persistence.*;
import lombok.*;


@Entity(name="userPosition")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserPositionEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true,name = "position_id")
    private String positionIdentity;
    private Status status = Status.active;
    private long sortOrder = 0;

    @Builder
    public UserPositionEntity(String name, String userPositionIdentity, Status status, long sortOrder) {
        this.name = name;
        this.positionIdentity = userPositionIdentity;
        this.status = status == null ? Status.active : status;;
        this.sortOrder = sortOrder;
    }
}
