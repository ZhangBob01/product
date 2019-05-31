package com.bob.product.client;

import com.bob.product.common.DecreaseStockInput;
import com.bob.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author toudaizhi
 * @Date: 2019-05-21 18:06
 * @Description:
 */
@FeignClient(name = "APP-BOB-PRODUCT")
public interface ProductClient {
    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
