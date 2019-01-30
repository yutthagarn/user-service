package com.example.userservice.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 * User: Cyl3erPunKz
 * Date: 30 January 2019
 * Time: 13:24
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckSalaryValidator.CheckSalaryValidatorBean.class)
public @interface CheckSalaryValidator {

    String message() default "{user.validator.salary.reject}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class CheckSalaryValidatorBean implements ConstraintValidator<CheckSalaryValidator, Long> {

        @Override
        public void initialize(CheckSalaryValidator constraintAnnotation) {

        }

        @Override
        public boolean isValid(Long salary, ConstraintValidatorContext context) {
            return salary >= 15000;
        }
    }

}
