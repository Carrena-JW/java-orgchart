package carrena.orgchart.service;

import carrena.orgchart.command.department.CreateDepartmentCommand;
import carrena.orgchart.command.user.CreateUserCommand;
import carrena.orgchart.command.user.CreateUserPositionCommand;
import carrena.orgchart.command.user.CreateUserRoleCommand;
import carrena.orgchart.command.user.CreateUserTitleCommand;
import carrena.orgchart.entity.UserPositionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

@SpringBootTest
@Transactional
@Rollback(false)
public class UserServiceIntTest {
    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;

    final int MAX_DEPARTMENT_LENGTH = 100;
    final int MAX_USER_LENGTH = 2000;

    List<String> positionContainer = new ArrayList<>();
    List<String> titleContainer = new ArrayList<>();
    List<String> roleContainer = new ArrayList<>();
    List<String> departmentContainer = new ArrayList<>();

    @Test
    void 벌크_생성() {
        /***
         * step01: 직급(position) 생성
         * step02: 호칭(title) 생성
         * step03: 직책(role) 생성
         * step04: 부서(department) 생성
         * step05: 사용자(user) 생성
         */
        long start = System.currentTimeMillis();




        직급_생성();
        호칭_생성();
        직책_생성();
        부서_생성();
        유저_생성();

        long finish = System.currentTimeMillis();
        long timeMs = finish - start;

        //38초 전후로 완료 됨
        System.out.println("Tests have been running for " + timeMs + "ms");
    }

    void 직급_생성() {
        // 사원, 대리, 과장, 차장, 부장, 이사, 전무, 사장

        List<String> positionList = new ArrayList<>(List.of("사원", "과장", "대리", "차장", "부장", "이사", "전무", "사장"));

        Function<Integer, String> createIdentity = (cnt) -> {
            return "P" + String.format("%04d", cnt);
        };

        int loopCount = 1;

        for (var p : positionList) {
            var positionCommand = new CreateUserPositionCommand(p, createIdentity.apply(loopCount), 1, loopCount, Optional.empty());
            userService.sendCommand(positionCommand);
            positionContainer.add(positionCommand.positionIdentity());
            loopCount++;
        }

    }

    void 호칭_생성() {
        // 사원, 대리, 과장, 차장, 부장, 이사, 전무, 사장
        // 주임, 전임, 선임, 책임, 수석


        List<String> titleList = new ArrayList<>(List.of("사원", "과장", "대리", "차장", "부장", "이사", "전무", "사장",
                "주임", "전임", "선임", "책임", "수석"));

        Function<Integer, String> createIdentity = (cnt) -> {
            return "T" + String.format("%04d", cnt);
        };

        int loopCount = 1;

        for (var p : titleList) {
            var titleCommand = new CreateUserTitleCommand(p, createIdentity.apply(loopCount), 1, loopCount, Optional.empty());
            userService.sendCommand(titleCommand);
            titleContainer.add(titleCommand.titleIdentity());
            loopCount++;
        }
    }

    void 직책_생성() {
        //팀원, 팀장, 공장장, 그룹장, 사장
        List<String> roleList = new ArrayList<>(List.of("팀원", "팀장", "공장장", "그룹장", "사장"));

        Function<Integer, String> createIdentity = (cnt) -> {
            return "R" + String.format("%04d", cnt);
        };

        int loopCount = 1;

        for (var p : roleList) {
            var roleCommand = new CreateUserRoleCommand(p, createIdentity.apply(loopCount), 1, loopCount, Optional.empty());
            userService.sendCommand(roleCommand);
            roleContainer.add(roleCommand.roleIdentity());
            loopCount++;
        }
    }

    void 부서_생성() {

        Function<Integer, String> createIdentity = (cnt) -> {
            return "D" + String.format("%04d", cnt);
        };

        for (int i = 1; i < MAX_DEPARTMENT_LENGTH; i++) {
            String identity = createIdentity.apply(i);
            var departmentCommand = new CreateDepartmentCommand(identity + "팀", identity, "", "", 1, i, Optional.empty());
            departmentService.saveOrUpdateDepartment(departmentCommand);
            departmentContainer.add(departmentCommand.departmentIdentity());
        }
    }

    void 유저_생성() {
        Function<Integer, String> createIdentity = (cnt) -> {
            return "U" + String.format("%05d", cnt);
        };

        for (int i = 1; i < MAX_USER_LENGTH; i++) {
            int departmentIndex = new Random().nextInt(departmentContainer.size());
            int titleIndex = new Random().nextInt(titleContainer.size());
            int roleIndex = new Random().nextInt(roleContainer.size());
            int positionIndex = new Random().nextInt(positionContainer.size());

            String identity = createIdentity.apply(i);
            var userCommand = new CreateUserCommand(identity + "이름",
                    identity,
                    Integer.toString(i),
                    identity + "@carrena.com",
                    "010-" + identity,
                    "02-" + identity,
                    1,
                    i,
                    departmentContainer.get(departmentIndex),
                    roleContainer.get(roleIndex),
                    titleContainer.get(titleIndex),
                    positionContainer.get(positionIndex),
                    true,
                    Optional.empty()
            );

            userService.sendCommand(userCommand);


        }
    }
}
