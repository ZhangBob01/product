package com.bob.product.VO;

import com.bob.product.dataobject.ProductInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 21:48
 * @Description: 商品对象
 */
@Data
public class ProductVO {

    /** 类目名称. */
    //以注解中的名称返回
    @JsonProperty("name")
    private String categoryName;

    /** 类目编码. */
    @JsonProperty("type")
    private Integer categoryType;

    /** 类目包含商品列表. */
    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}
