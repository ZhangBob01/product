package com.bob.product.common;

import lombok.Data;

/**
 * @author toudaizhi
 * @Date: 2019-05-21 00:06
 * @Description:
 */
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
