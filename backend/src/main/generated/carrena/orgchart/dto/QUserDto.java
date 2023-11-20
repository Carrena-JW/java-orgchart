package carrena.orgchart.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * carrena.orgchart.dto.QUserDto is a Querydsl Projection type for UserDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserDto extends ConstructorExpression<UserDto> {

    private static final long serialVersionUID = 1124080869L;

    public QUserDto(com.querydsl.core.types.Expression<String> userIdentity, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> userEmail, com.querydsl.core.types.Expression<String> userPhoneNumber, com.querydsl.core.types.Expression<String> userOfficeTel, com.querydsl.core.types.Expression<String> departmentName, com.querydsl.core.types.Expression<String> titleName, com.querydsl.core.types.Expression<String> roleName, com.querydsl.core.types.Expression<String> positionName) {
        super(UserDto.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, userIdentity, userName, userEmail, userPhoneNumber, userOfficeTel, departmentName, titleName, roleName, positionName);
    }

}

