package com.bob.product.service.impl;

import com.bob.product.dao.CategoryDAO;
import com.bob.product.dataobject.ProductCategory;
import com.bob.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 22:08
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<ProductCategory> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public List<ProductCategory> findProductCategoryIn(List<Integer> typeList) {
        return categoryDAO.findByProductCategoryIn(typeList);
    }
}
