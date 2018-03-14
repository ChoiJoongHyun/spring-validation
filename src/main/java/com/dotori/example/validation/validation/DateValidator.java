package com.dotori.example.validation.validation;

import com.dotori.example.validation.constant.DateFormatConstant;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements ConstraintValidator<DateValid, String> {

    public final static LocalDateTime MIN_DATE = LocalDateTime.of(2017,1,1,0,0,0);
    public final static String MIN_DATE_MSG = "2017년 1월 1일";

    @Override
    public void initialize(DateValid constraintAnnotation) { }

    /**
     * value 값으로 validation check 를 진행한다.
     * 1. 검색가능한 범위인지 확인
     * 2. LocalDateTime 으로 변환되는지 확인
     * */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null 허용.
        if(StringUtils.isEmpty(value)) {
            return true;
        }
        //localDateTime 으로 변환되는지 검증.
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatConstant.YYYYMMDDHHMMSS);
            LocalDateTime date = LocalDateTime.parse(value, formatter);
            //최소 검색 시간 검증.
            if(date.isBefore(MIN_DATE)) {
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
