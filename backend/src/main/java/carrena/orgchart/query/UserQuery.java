package carrena.orgchart.query;

import carrena.orgchart.dto.QUserDto;
import carrena.orgchart.dto.UserDto;
import carrena.orgchart.entity.UserMapEntity;
import carrena.orgchart.query.request.FindUserRequest;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static carrena.orgchart.entity.QUserMapEntity.userMapEntity;

@Repository
@RequiredArgsConstructor
public class UserQuery {
    private final JPAQueryFactory factory;

    public List<UserDto> findAllUsers(){
        return factory.select(new QUserDto(
                        userMapEntity.user.userIdentity,
                        userMapEntity.user.name,
                        userMapEntity.user.email,
                        userMapEntity.user.phoneNumber,
                        userMapEntity.user.officeTel,
                        userMapEntity.department.name,
                        userMapEntity.title.name,
                        userMapEntity.role.name,
                        userMapEntity.position.name))
                .limit(10)
                .from(userMapEntity)
                .fetch();
    }
    public List<UserDto> findAllUsers(FindUserRequest request){
        return factory.select(new QUserDto(
                        userMapEntity.user.userIdentity,
                        userMapEntity.user.name,
                        userMapEntity.user.email,
                        userMapEntity.user.phoneNumber,
                        userMapEntity.user.officeTel,
                        userMapEntity.department.name,
                        userMapEntity.title.name,
                        userMapEntity.role.name,
                        userMapEntity.position.name))
//                .limit(10)
                .from(userMapEntity)
                .where(
                        StringUtils.isNullOrEmpty(request.keyword()) ? null :
                        userMapEntity.user.userIdentity.containsIgnoreCase(request.keyword())
                        .or(userMapEntity.user.name.containsIgnoreCase(request.keyword()))
                        .or(userMapEntity.user.email.containsIgnoreCase(request.keyword()))
                        .or(userMapEntity.user.phoneNumber.containsIgnoreCase(request.keyword()))
                        .or(userMapEntity.user.officeTel.containsIgnoreCase(request.keyword()))
                        .or(userMapEntity.department.name.containsIgnoreCase(request.keyword()))
                        .or(userMapEntity.title.name.containsIgnoreCase(request.keyword()))
                        .or(userMapEntity.role.name.containsIgnoreCase(request.keyword()))
                        .or(userMapEntity.position.name.containsIgnoreCase(request.keyword())))
                .fetch();
    }

    public List<UserMapEntity> findAllUsersNoDto(){
        return factory.selectFrom(userMapEntity).limit(10).fetch();
    }

}


