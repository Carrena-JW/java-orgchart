package carrena.orgchart.controller;

import carrena.orgchart.command.department.CreateDepartmentCommand;
import carrena.orgchart.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/api/department")
    public Long saveOrUpdateDepartment(@RequestBody CreateDepartmentCommand command) {
        return departmentService.saveOrUpdateDepartment(command);
    }

}
