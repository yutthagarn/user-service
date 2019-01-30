package com.example.userservice.utils;

import com.example.userservice.domain.MemberType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Cyl3erPunKz
 * Date: 30 January 2019
 * Time: 10:56
 **/
public class CommonUtils {

    public static String createRegisterDate(String mobileNo) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + mobileNo.substring(mobileNo.length() - 4);
    }

    public static MemberType calculateMemberType(Long salary) {
        if (salary > 50000) {
            return MemberType.PLATINUM;
        } else if (salary >= 30000) {
            return MemberType.GOLD;
        } else {
            return MemberType.SILVER;
        }
    }

}
