package com.dotori.example.validation.controller.content.request;

import com.dotori.example.validation.enums.Category;
import com.dotori.example.validation.validation.CategoryValid;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Setter
@NoArgsConstructor
public class ContentRequest {

    @CategoryValid
    private String category;

    /**
     * @return Category enum 값.
     * */
    public Category getCategory() {
        if(StringUtils.isEmpty(category)) {
            return null;
        }
        return Category.valueOf(category);
    }
}