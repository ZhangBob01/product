package com.bob.product.utils;

import com.bob.product.VO.ResultVO;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-15 09:34
 * @Description: http请求返回值工具类
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
