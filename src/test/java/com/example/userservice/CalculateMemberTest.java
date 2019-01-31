package com.example.userservice;

import com.example.userservice.domain.MemberType;
import com.example.userservice.utils.CommonUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Cyl3erPunKz
 * Date: 31 January 2019
 * Time: 09:22
 **/
public class CalculateMemberTest {

    @Test
    public void shouldBePlatinum() {
        long salary = 55000;
        MemberType memberType = CommonUtils.calculateMemberType(salary);
        Assertions.assertThat(memberType).isEqualTo(MemberType.PLATINUM);
    }

    @Test
    public void shouldBeGold() {
        long salary = 45000;
        MemberType memberType = CommonUtils.calculateMemberType(salary);
        Assertions.assertThat(memberType).isEqualTo(MemberType.GOLD);
    }

    @Test
    public void shouldBeSilver() {
        long salary = 25000;
        MemberType memberType = CommonUtils.calculateMemberType(salary);
        Assertions.assertThat(memberType).isEqualTo(MemberType.SILVER);
    }

}
