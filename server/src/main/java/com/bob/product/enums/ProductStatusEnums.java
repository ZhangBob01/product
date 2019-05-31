package com.bob.product.enums;

import lombok.Getter;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 21:33
 * @Description:
 */
@Getter
public enum ProductStatusEnums {
    UP(1,"在架"),
    DOWN(0,"下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
