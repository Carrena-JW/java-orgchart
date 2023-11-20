package carrena.orgchart.command.department;

public record CreateDepartmentCommand(String departmentName,
                                      String departmentIdentity,
                                      String parentDepartmentIdentity,
                                      String departmentManagerIdentity,
                                      int departmentStatus,
                                      int sortOrder
                                ) {

}
