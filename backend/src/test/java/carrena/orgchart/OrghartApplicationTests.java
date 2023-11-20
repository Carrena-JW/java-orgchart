package carrena.orgchart;

import carrena.orgchart.entity.*;
import carrena.orgchart.repository.*;
import carrena.orgchart.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class OrghartApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    UserTitleRepository userTitleRepository;
    @Autowired
    UserPositionRepository userPositionRepository;
    @Autowired
    UserDepartmentRepository userDepartmentRepository;


    //region Repository 검증
    @Test
    void 사용자_저장() {

        UserEntity user = UserEntity.builder()
                .name("황지웅")
                .userNumber("0001")
                .email("carrena@naver.com")
                .userIdentity("carrena")
                .phoneNumber("010-9082-1642")
                .officeTel("02-9082-1642")
                .build();

        var createdUser = userRepository.save(user);

        assertThat(createdUser).isEqualTo(user);
    }

    @Test
    void 사용자_부서_저장() {
        UserDepartmentEntity department = UserDepartmentEntity.builder()
                .name("사장실")
                .departmentIdentity("D0000")
                .departmentManagerIdentity("carrena")
                .parentDepartmentIdentity("D000")
                .build();

        var createdDepartment = userDepartmentRepository.save(department);
        assertThat(department).isEqualTo(createdDepartment);
    }

    @Test
    void 사용자_호칭_저장(){
        UserTitleEntity title = UserTitleEntity.builder()
                .userTitleIdentity("T000")
                .name("주임")
                .build();

        var result = userTitleRepository.save(title);
        assertThat(title).isEqualTo(result);
    }

    @Test
    void 사용자_직책_저장(){
        UserRoleEntity role = UserRoleEntity.builder()
                .name("팀원")
                .userRoleIdentity("R000")
                .build();

        var result = userRoleRepository.save(role);
        assertThat(role).isEqualTo(result);
    }

    @Test
    void 사용자_직급_저장(){
        UserPositionEntity position = UserPositionEntity.builder()
                .name("과장")
                .userPositionIdentity("P000")
                .build();
        var result = userPositionRepository.save(position);

        assertThat(position).isEqualTo(result);
    }

    @Test
    void 사용자_존재유무_조회() {

        UserEntity user = UserEntity.builder()
                .name("황지웅")
                .userNumber("0001")
                .email("carrena@naver.com")
                .userIdentity("carrena")
                .phoneNumber("010-9082-1642")
                .officeTel("02-9082-1642")
                .build();

        var result = userRepository.save(user);
        var isExists = userRepository.existsByUserIdentity(result.getUserIdentity());
        var findResult = userRepository.findByUserIdentity(result.getUserIdentity());
        assertThat(result.getId()).isEqualTo(findResult.get().getId());

        assertThat(isExists).isEqualTo(true);
    }
    @Test
    void 사용자_부서_존재유무_조회(){
        UserDepartmentEntity department = UserDepartmentEntity.builder()
                .name("사장실")
                .departmentIdentity("D0000")
                .departmentManagerIdentity("carrena")
                .parentDepartmentIdentity("D000")
                .build();

        var result = userDepartmentRepository.save(department);
        var isExists = userDepartmentRepository.existsByDepartmentIdentity(result.getDepartmentIdentity());
        var findResult = userDepartmentRepository.findByDepartmentIdentity(result.getDepartmentIdentity());
        assertThat(isExists).isEqualTo(true);
        assertThat(result.getId()).isEqualTo(findResult.get().getId());
    }

    @Test
    void 사용자_직위_존재유무_조회(){
        UserPositionEntity position = UserPositionEntity.builder()
                .name("과장")
                .userPositionIdentity("P000")
                .build();
        var result = userPositionRepository.save(position);
        var isExists = userPositionRepository.existsByPositionIdentity(result.getPositionIdentity());
        var findResult = userPositionRepository.findByPositionIdentity(result.getPositionIdentity());
        assertThat(isExists).isEqualTo(true);
        assertThat(result.getId()).isEqualTo(findResult.get().getId());
    }

    @Test
    void 사용자_직책_존재유무_조회(){
        UserRoleEntity role = UserRoleEntity.builder()
                .name("팀원")
                .userRoleIdentity("R000")
                .build();

        var result = userRoleRepository.save(role);
        var isExists = userRoleRepository.existsByRoleIdentity(result.getRoleIdentity());
        var findResult = userRoleRepository.findByRoleIdentity(result.getRoleIdentity());
        assertThat(isExists).isEqualTo(true);
        // 조회된 결과 id 비교
        assertThat(result.getId()).isEqualTo(findResult.get().getId());
    }

    @Test
    void 사용자_호칭_존재유무_조회(){
        UserTitleEntity title = UserTitleEntity.builder()
                .userTitleIdentity("T000")
                .name("주임")
                .build();

        var result = userTitleRepository.save(title);
        var isExists = userTitleRepository.existsByTitleIdentity(result.getTitleIdentity());
        var findResult = userTitleRepository.findByTitleIdentity(result.getTitleIdentity());
        assertThat(isExists).isEqualTo(true);
        assertThat(result.getId()).isEqualTo(findResult.get().getId());
    }
    //endregion


    //region Service
    @Test
    void 서비스_사용자_생성(){

    }
    //endregion



    //region ETC
    @Test
    void 레코드_클래스_검증(){
//        var com1 = new CreateUserCommand("jw", 12);
//        var com2 = new CreateUserCommand("jw", 12);
//
//        assertThat(com1).isEqualTo(com2);
    }
    //endregion



    @Test
    void 서비스_인젝션_검증(){
//        Long result = userService.createUser();
//        assertThat(result).isEqualTo(0);
    }
}
