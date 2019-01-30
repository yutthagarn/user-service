package com.example.userservice.domain;

import com.example.userservice.validator.CheckSalaryValidator;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Cyl3erPunKz
 * Date: 29 January 2019
 * Time: 14:30
 **/
@Entity
@Table(name = "USER")
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "USERNAME", unique = true, nullable = false, length = 20)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 100)
    private String lastName;

    @Column(name = "MOBILE_NO", nullable = false, length = 10)
    private String mobileNo;

    @CheckSalaryValidator
    @Column(name = "SALARY", nullable = false)
    private long salary;

    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBER_TYPE", nullable = false)
    private MemberType memberType;

    @Column(name = "REGISTER_DATE", nullable = false, length = 12)
    private String registerDate;

    public User() {
    }

}
