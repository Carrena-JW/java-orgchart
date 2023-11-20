package carrena.orgchart.controller;

import carrena.orgchart.command.CreateUserCommand;
import carrena.orgchart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Long createUser(@RequestBody CreateUserCommand command){
        return userService.saveOrUpdateUser(command);
    }

    @GetMapping("/api/user")
    public String getUser(){
        return "user";
    }
}
