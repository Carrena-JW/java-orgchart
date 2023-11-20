package carrena.orgchart.command;

import java.util.Optional;

public record CreateUserCommand(String userName,
                                String userIdentity,
                                String userNumber,
                                String userEmail,
                                String userPhoneNumber,
                                String userOfficeTel,
                                int userStatus,
                                int sortOrder,
                                String userDepartmentIdentity,
                                String userRoleIdentity,
                                String userTitleIdentity,
                                String userPositionIdentity,
                                Boolean isMainJob
                                ) {

}
