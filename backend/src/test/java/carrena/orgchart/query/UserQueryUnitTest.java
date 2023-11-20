package carrena.orgchart.query;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserQueryUnitTest {

    @Autowired
    UserQuery userQuery;

    @Test
    void 쿼리_테스트(){
        var users = userQuery.findAllUsers();
        var usersNoDtop = userQuery.findAllUsersNoDto();

        for (var u : users){
            System.out.println(u.getUserName());
        }
    }
}
