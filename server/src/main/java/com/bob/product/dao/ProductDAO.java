package com.bob.product.dao;

import com.bob.product.dataobject.ProductInfo;

import java.util.List;


/**
 * @Auther: toudaizhi
 * @Date: 2019-04-12 15:34
 * @Description:
 */

public interface ProductDAO {

    /**
     * 新增商品
     * @param productInfo
     * @return
     */
    int insert(ProductInfo productInfo);

    /**
     * 根据商品名称查询
     * @param productName
     * @return
     */
    List<ProductInfo> findByProductName(String productName);

    /**
     * 更新商品
     * @param productInfo
     * @return
     */
    int update(ProductInfo productInfo);

    /**
     * 删除商品
     * @param productId
     * @return
     */
    int delete(String productId);

    /**
     * 根据商品状态查询商品
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
    /**
     * 查询所有商品
     *
     * @return
     */
    List<ProductInfo> findAll();

    /**
     * 根据Id查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdList(List<String> productIdList);

    /**
     * 根据Id查询商品信息
     * @param productId
     * @return
     */
    ProductInfo findById(String productId);
}
