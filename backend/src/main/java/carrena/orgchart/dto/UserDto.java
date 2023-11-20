package carrena.orgchart.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String userIdentity;
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String userOfficeTel;
    private String departmentName;
    private String titleName;
    private String roleName;
    private String positionName;

    @QueryProjection
    public UserDto(String userIdentity, String userName, String userEmail, String userPhoneNumber, String userOfficeTel, String departmentName, String titleName, String roleName, String positionName) {
        this.userIdentity = userIdentity;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userOfficeTel = userOfficeTel;
        this.departmentName = departmentName;
        this.titleName = titleName;
        this.roleName = roleName;
        this.positionName = positionName;
    }
}