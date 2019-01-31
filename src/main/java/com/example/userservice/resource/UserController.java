package com.example.userservice.resource;

import com.example.userservice.domain.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: Cyl3erPunKz
 * Date: 29 January 2019
 * Time: 15:44
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody @Validated User user) {
        return userService.register(user);
    }

    @GetMapping
    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
