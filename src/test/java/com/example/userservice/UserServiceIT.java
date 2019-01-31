package com.example.userservice;

import com.example.userservice.domain.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;

/**
 * Created by IntelliJ IDEA.
 * User: Cyl3erPunKz
 * Date: 31 January 2019
 * Time: 09:53
 **/
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceIT {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerUser() {
        User user = new User();
        user.setUsername("cyberpunkz");
        user.setPassword("abc123");
        user.setFirstName("Yutthagarn");
        user.setLastName("Intajug");
        user.setMobileNo("0812345678");
        user.setSalary(20000);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Mockito.when(bCryptPasswordEncoder.encode(any())).thenReturn(any());
        User result = userService.register(user);
        Assertions.assertThat(result).isNotNull();
    }

}
