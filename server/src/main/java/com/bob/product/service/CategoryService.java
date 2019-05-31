package com.bob.product.service;

import com.bob.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 22:04
 * @Description:类目
 */
public interface CategoryService {

    /**
     * 查询所有类目
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据类目编码查询类目信息列表
     * @param typeList
     * @return
     */
    List<ProductCategory> findProductCategoryIn(List<Integer> typeList);
}
