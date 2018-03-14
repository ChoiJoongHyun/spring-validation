package com.dotori.example.validation.controller.content.request;

import com.dotori.example.validation.constant.DateFormatConstant;
import com.dotori.example.validation.enums.Category;
import com.dotori.example.validation.validation.CategoryValid;
import com.dotori.example.validation.validation.DateValid;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@NoArgsConstructor
public class ContentRequest {

    @NotBlank
    @CategoryValid
    private String category;

    @DateValid
    private String from;

    /**
     * @return Category enum 값.
     * */
    public Category getCategory() {
        if(StringUtils.isEmpty(this.category)) {
            return null;
        }
        return Category.valueOf(category.toUpperCase());
    }

    /**
     * @return LocalDateTime 으로 변환된 from 값.
     * */
    public LocalDateTime getFrom() {
        if(StringUtils.isEmpty(this.from)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatConstant.YYYYMMDDHHMMSS);
        return LocalDateTime.parse(this.from, formatter);
    }
}