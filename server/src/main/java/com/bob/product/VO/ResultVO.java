package com.bob.product.VO;

import lombok.Data;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 21:40
 * @Description: http请求返回的最外层对象
 */

@Data
public class ResultVO<T> {

    /** 返回码. */
    private Integer code;

    /** 返回消息. */
    private String message;

    /** 返回数据. */
    private T data;
}
