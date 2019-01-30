package com.example.userservice.resource;

import com.example.userservice.domain.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.utils.CommonUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody @Validated User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRegisterDate(CommonUtils.createRegisterDate(user.getMobileNo()));
        user.setMemberType(CommonUtils.calculateMemberType(user.getSalary()));
        return userRepository.save(user);
    }

    @GetMapping
    public Page<User> getAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
