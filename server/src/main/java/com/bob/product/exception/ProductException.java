package com.bob.product.exception;

import com.bob.product.enums.ResultEnum;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-19 10:52
 * @Description:
 */
public class ProductException extends RuntimeException {

    /**
     * 异常编码
     */
    private Integer code;

    public ProductException(Integer code, String message){

        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
