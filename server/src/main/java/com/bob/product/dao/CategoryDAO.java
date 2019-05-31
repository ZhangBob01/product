package com.bob.product.dao;

import com.bob.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 22:09
 * @Description:
 */
public interface CategoryDAO {

    /**
     * 根据类目编码查询类目列表
     * @param typeList
     * @return
     */
    List<ProductCategory> findByProductCategoryIn(List<Integer> typeList);

    /**
     * 查询类目列表
     * @return
     */
    List<ProductCategory> findAll();
}
