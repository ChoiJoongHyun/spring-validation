package com.dotori.example.validation.enums;

import lombok.Getter;

/**
 * 카테고리 정보
 * */
public enum Category {
    FOOD (true),
    IT (true),
    MUSIC (true),
    LIFE (false),
    GAME (false);

    @Getter
    private boolean activation;

    Category(boolean activation) {
        this.activation = activation;
    }

    /**
     * @param categoryStr 카테고리 str 값.
     * @return category 가 활셩되어있으면 true, 아니면 false
     * */
    public static boolean isActivation(String categoryStr) {
        try {
            return isActivation(Category.valueOf(categoryStr.toUpperCase()));
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * @param category 카테고리 enum 값.
     * @return category 가 활셩되어있으면 true, 아니면 false
     * */
    public static boolean isActivation(Category category) {
        if(category == null) {
            return false;
        }
        return category.isActivation();
    }
}
