package com.dotori.example.validation.validation;

import com.dotori.example.validation.enums.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<CategoryValid, String> {

    @Override
    public void initialize(CategoryValid constraintAnnotation) { }

    /**
     * value 값으로 validation check 를 진행한다.
     * @return 현재 허용가능한 카테고리면 true, 아니면 false
     * */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Category.isActivation(value);
    }
}
