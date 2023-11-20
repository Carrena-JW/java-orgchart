package carrena.orgchart.command.department;

import java.util.Optional;

public record CreateDepartmentCommand(String departmentName,
                                      String departmentIdentity,
                                      String parentDepartmentIdentity,
                                      String departmentManagerIdentity,
                                      int departmentStatus,
                                      int sortOrder,
                                      Optional<Long> id
                                      ) {

}
