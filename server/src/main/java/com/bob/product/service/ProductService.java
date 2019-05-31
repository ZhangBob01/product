package com.bob.product.service;

import com.bob.product.common.DecreaseStockInput;
import com.bob.product.common.ProductInfoOutput;
import com.bob.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 09:02
 * @Description:
 */
public interface ProductService {
    /**
     * 新增商品
     * @param productInfo
     * @return
     */
    int insert(ProductInfo productInfo);

    /**
     * 更新商品信息
     * @param productInfo
     * @return
     */
    int update(ProductInfo productInfo);

    /**
     * 查询所有商品
     * @return
     */
    List<ProductInfo> findAll();

    /**
     * 查询在架商品
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 查询订单商品
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findByProductIdList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
