package com.bob.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 21:54
 * @Description:
 */
@Data
public class ProductInfoVO {

    /** 商品Id. */
    @JsonProperty("id")
    private String productId;

    /** 商品名称. */
    @JsonProperty("name")
    private String productName;

    /** 商品单价. */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 商品图片. */
    @JsonProperty("icon")
    private String productIcon;

    /** 商品描述. */
    @JsonProperty("description")
    private String productDescription;
}
