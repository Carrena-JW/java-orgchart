package carrena.orgchart.controller;

import carrena.orgchart.command.department.CreateDepartmentCommand;
import carrena.orgchart.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping("/api/department")
    public Long saveOrUpdateDepartment(@RequestBody CreateDepartmentCommand command) {
        return departmentService.saveOrUpdateDepartment(command);
    }

}
