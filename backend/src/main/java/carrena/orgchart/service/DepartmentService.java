package carrena.orgchart.service;

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

    public Long saveOrUpdateDepartment(){
//        userDepartmentRepository.
        return 0L;
    }

}
