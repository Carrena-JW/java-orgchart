package carrena.orgchart.entity;

import carrena.orgchart.enums.Status;
import jakarta.persistence.*;
import lombok.*;


@Entity(name="user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true,name = "user_id")
    private String userIdentity;
    @Column(nullable = false, unique = true)
    private String userNumber;
    @Column(nullable = true, unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String phoneNumber;
    @Column(nullable = true, unique = true)
    private String officeTel;
    private Status status = Status.active;
    private long sortOrder = 0;

    @Builder
    public UserEntity(long sortOrder,Status status,String name, String userIdentity, String userNumber, String email, String phoneNumber, String officeTel) {
        this.name = name;
        this.userIdentity = userIdentity;
        this.userNumber = userNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.officeTel = officeTel;
        this.status = status;
        this.sortOrder = sortOrder;
    }
}
