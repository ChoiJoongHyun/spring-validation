package com.dotori.example.validation.validation;

import com.dotori.example.validation.constant.DateFormatConstant;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface DateValid {
    // message 정의
    String message() default "날짜는 " + DateValidator.MIN_DATE_MSG + " 보다 커야 하며, " + "포멧은 "+ DateFormatConstant.YYYYMMDDHHMMSS +" 형식으로 보내야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
