package carrena.orgchart.controller;

import carrena.orgchart.command.user.*;
import carrena.orgchart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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




}
