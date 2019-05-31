package com.bob.product.dao.impl;

import com.bob.product.dao.CategoryDAO;
import com.bob.product.dataobject.ProductCategory;
import com.bob.product.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 22:11
 * @Description:
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    private ProductCategoryMapper mapper;

    @Override
    public List<ProductCategory> findByProductCategoryIn(List<Integer> typeList) {
        return mapper.findBytCategoryTypeIn(typeList);
    }

    @Override
    public List<ProductCategory> findAll() {
        return mapper.findAll();
    }
}
