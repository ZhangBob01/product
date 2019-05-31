package com.bob.product.enums;

import lombok.Getter;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-19 10:57
 * @Description:
 */
@Getter
public enum ResultEnum {

    /**
     * 返回信息
     */
    PRODUCT_NOT_EXIT(1001,"商品不存在"),
    PRODUCT_STOCK_ERROR(1002,"商品库存不足")
    ;

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
