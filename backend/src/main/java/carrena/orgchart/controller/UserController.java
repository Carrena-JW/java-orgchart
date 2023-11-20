package carrena.orgchart.controller;

import carrena.orgchart.command.user.*;
import carrena.orgchart.query.UserQuery;
import carrena.orgchart.query.request.FindUserRequest;
import carrena.orgchart.query.response.FindUserResponse;
import carrena.orgchart.service.UserService;
import com.querydsl.core.util.StringUtils;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;
    private final UserQuery userQuery;

    @Autowired
    public UserController(UserService userService, UserQuery userQuery) {
        this.userService = userService;
        this.userQuery = userQuery;
    }

    //region COMMAND
    @PostMapping("/api/user")
    public Long saveOrUpdateUser(@RequestBody CreateUserCommand command){
        return userService.sendCommand(command);
    }

    @PostMapping("/api/user/title")
    public Long saveOrUpdateUserTitle(@RequestBody CreateUserTitleCommand command){
        return userService.sendCommand(command);
    }

    @PostMapping("/api/user/position")
    public Long saveOrUpdateUserPosition(@RequestBody CreateUserPositionCommand command){
        return userService.sendCommand(command);
    }

    @PostMapping("/api/user/role")
    public Long saveOrUpdateUserRole(@RequestBody CreateUserRoleCommand command){
        return userService.sendCommand(command);
    }

    //endregion


    //region QUERY
    @GetMapping("/api/user")
    public FindUserResponse findUser(@Nullable @ModelAttribute FindUserRequest request){
        return  FindUserResponse.builder()
                .users(StringUtils.isNullOrEmpty(request.keyword())  ? userQuery.findAllUsers() : userQuery.findAllUsers(request))
                .totalCount(0L)
                .currentPage(1L)
                .build();
    }
    //endregion


}
