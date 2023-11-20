package carrena.orgchart.service;

import carrena.orgchart.command.user.*;
import carrena.orgchart.entity.*;
import carrena.orgchart.enums.Status;
import carrena.orgchart.enums.UserCommandType;
import carrena.orgchart.enums.UserValidationType;
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

    /***
     * 모든 서비스에 진입점을 통일 시키고 외부에 서비스 내부 함수를 노출 시키지 않음
     * 타 모듈에서 무분별한 변조를 방지 함
     * @param command
     * @return
     */
    public Long sendCommand(UserCommand command) {

        UserCommandType type = getUserCommandType(command);

        switch (type.name()) {
            case "createUserCommand": //user
                return saveOrUpdateUser((CreateUserCommand) command);
            case "createUserTitleCommand": //title
                return saveOrUpdateUserTitle((CreateUserTitleCommand) command);
            case "createUserRoleCommand": //role
                return saveOrUpdateUserRole((CreateUserRoleCommand) command);
            case "createUserPositionCommand": //position
                return saveOrUpdateUserPosition((CreateUserPositionCommand) command);
            default:
                try {
                    throw new IllegalAccessException(type.toString() + " : this command is wrong.");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private Long saveOrUpdateUser(CreateUserCommand command) {
        //identity 로 유료성 체크
        validationByIdentity(UserValidationType.user, command.userIdentity());

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

        //id 를 보유한 경우 entity 에 id 값 추가 update case
        command.id().ifPresent(id -> {
            user.setId(command.id().get());
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

    private Long saveOrUpdateUserTitle(CreateUserTitleCommand command) {
        //identity 로 유료성 체크
        validationByIdentity(UserValidationType.title, command.titleIdentity());

        var title = UserTitleEntity.builder()
                .userTitleIdentity(command.titleIdentity())
                .name(command.titleName())
                .status(Status.values()[command.titleStatus()])
                .sortOrder(command.sortOrder())
                .build();

        //id 를 보유한 경우 entity 에 id 값 추가 update case
        command.id().ifPresent(id -> {
            title.setId(command.id().get());
        });

        var result = userTitleRepository.save(title);

        return result.getId();
    }

    private Long saveOrUpdateUserRole(CreateUserRoleCommand command) {
        //identity 로 유료성 체크
        validationByIdentity(UserValidationType.role, command.roleIdentity());

        var role = UserRoleEntity.builder()
                .name(command.roleName())
                .userRoleIdentity(command.roleIdentity())
                .status(Status.values()[command.roleStatus()])
                .sortOrder(command.sortOrder())
                .build();

        //id 를 보유한 경우 entity 에 id 값 추가 update case
        command.id().ifPresent(id -> {
            role.setId(command.id().get());
        });

        var result = userRoleRepository.save(role);

        return result.getId();
    }

    private Long saveOrUpdateUserPosition(CreateUserPositionCommand command) {
        validationByIdentity(UserValidationType.position, command.positionIdentity());

        var position = UserPositionEntity.builder()
                .name(command.positionName())
                .userPositionIdentity(command.positionIdentity())
                .status(Status.values()[command.positionStatus()])
                .sortOrder(command.sortOrder())
                .build();

        command.id().ifPresent(id -> {
            position.setId(command.id().get());
        });

        var result = userPositionRepository.save(position);

        return result.getId();
    }

    private UserCommandType getUserCommandType(UserCommand command) {
        var commandClass = command.getClass();

        if (commandClass == CreateUserTitleCommand.class) {
            return UserCommandType.createUserTitleCommand;
        } else if (commandClass == CreateUserCommand.class) {
            return UserCommandType.createUserCommand;
        } else if (commandClass == CreateUserPositionCommand.class) {
            return UserCommandType.createUserPositionCommand;
        } else if (commandClass == CreateUserRoleCommand.class) {
            return UserCommandType.createUserRoleCommand;
        } else {
            return UserCommandType.unknownCommand;
        }
    }

    private void validationByIdentity(UserValidationType type, String identity) {

        //예외 throw 익명 함수
        Runnable throwException = () -> {
            throw new IllegalStateException(identity + " " + type.toString() + " already exists.");
        };

        switch (type.getValue()) {
            case 0: //user
                userRepository.findByUserIdentity(identity).ifPresent(u -> {
                    throwException.run();
                });
                break;
            case 1: //title
                userTitleRepository.findByTitleIdentity(identity).ifPresent(t -> {
                    throwException.run();
                });
                break;
            case 2: //role
                userRoleRepository.findByRoleIdentity(identity).ifPresent(r -> {
                    throwException.run();
                });
                break;
            case 3: //position
                userPositionRepository.findByPositionIdentity(identity).ifPresent(p -> {
                    throwException.run();
                });
                break;
        }
    }

}
