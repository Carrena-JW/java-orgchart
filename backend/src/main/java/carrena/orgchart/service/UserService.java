package carrena.orgchart.service;

import carrena.orgchart.command.CreateUserCommand;
import carrena.orgchart.entity.UserEntity;
import carrena.orgchart.entity.UserMapEntity;
import carrena.orgchart.enums.Status;
import carrena.orgchart.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapRepository userMapRepository;
    private final UserDepartmentRepository userDepartmentRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserTitleRepository userTitleRepository;
    private final UserPositionRepository userPositionRepository;

    @Autowired
    public UserService(UserMapRepository userMapRepository, UserRepository userRepository, UserDepartmentRepository userDepartmentRepository, UserRoleRepository userRoleRepository, UserTitleRepository userTitleRepository, UserPositionRepository userPositionRepository) {
        this.userRepository = userRepository;
        this.userMapRepository = userMapRepository;
        this.userDepartmentRepository = userDepartmentRepository;
        this.userRoleRepository = userRoleRepository;
        this.userTitleRepository = userTitleRepository;
        this.userPositionRepository = userPositionRepository;
    }

    public Long saveOrUpdateUser(CreateUserCommand command) {
        //User Entity 생성
        var user = UserEntity.builder()
                .userNumber(command.userNumber())
                .userIdentity(command.userIdentity())
                .phoneNumber(command.userPhoneNumber())
                .name(command.userName())
                .email(command.userEmail())
                .officeTel(command.userOfficeTel())
                .sortOrder(command.sortOrder())
                .status(Status.values()[command.userStatus()])
                .build();

        //user 조회해서 결과과 있으면 user entity id 추가
        userRepository.findByUserIdentity(command.userIdentity()).ifPresent(u-> {
            user.setId(u.getId());
        });

        //조회 및 유효성 체크
        var department = userDepartmentRepository.findByDepartmentIdentity(command.userDepartmentIdentity())
                .orElseThrow(() -> new EntityNotFoundException("Department not found."));

        var role = userRoleRepository.findByRoleIdentity(command.userRoleIdentity())
                .orElseThrow(() -> new EntityNotFoundException("User Role not found."));

        var title = userTitleRepository.findByTitleIdentity(command.userTitleIdentity())
                .orElseThrow(() -> new EntityNotFoundException("User Title not found"));

        var position = userPositionRepository.findByPositionIdentity(command.userPositionIdentity())
                .orElseThrow(() -> new EntityNotFoundException("User Position not found."));

        //User Map Entity 생성
        var userMap = UserMapEntity.builder()
                .user(user)
                .title(title)
                .department(department)
                .position(position)
                .role(role)
                .isMainJob(command.isMainJob())
                .build();

        //User , UserMap Entity Commit
        var result = userRepository.save(user);
        userMapRepository.save(userMap);

        return result.getId();
    }

//    private Boolean validationValue()
}
