package carrena.orgchart.service;

import carrena.orgchart.command.department.CreateDepartmentCommand;
import carrena.orgchart.entity.UserDepartmentEntity;
import carrena.orgchart.enums.Status;
import carrena.orgchart.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DepartmentService {

    private final UserDepartmentRepository userDepartmentRepository;

    @Autowired
    public DepartmentService(UserDepartmentRepository userDepartmentRepository) {
        this.userDepartmentRepository = userDepartmentRepository;
    }

    public Long saveOrUpdateDepartment(CreateDepartmentCommand command){
        var department = UserDepartmentEntity.builder()
                .name(command.departmentName())
                .parentDepartmentIdentity(command.parentDepartmentIdentity())
                .departmentIdentity(command.departmentIdentity())
                .departmentManagerIdentity(command.departmentManagerIdentity())
                .sortOrder(command.sortOrder())
                .status(Status.values()[command.departmentStatus()])
                .build();


        validationByDepartmentIdentity(command.departmentIdentity());
        var result = userDepartmentRepository.save(department);

        return result.getId();
    }

    private void validationByDepartmentIdentity(String departmentIdentity){
        userDepartmentRepository.findByDepartmentIdentity(departmentIdentity).ifPresent(d->{
            throw new IllegalStateException(departmentIdentity + " department already exists.");
        });
    }

}
