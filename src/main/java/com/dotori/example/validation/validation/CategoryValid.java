package com.dotori.example.validation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryValidator.class)
public @interface CategoryValid {
    // message 정의
    String message() default "허용하지 않는 카테고리 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
