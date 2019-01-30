package com.example.userservice.repository;

import com.example.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Cyl3erPunKz
 * Date: 29 January 2019
 * Time: 14:55
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
