package com.bob.product.dao.impl;

import com.bob.product.dao.ProductDAO;
import com.bob.product.dataobject.ProductInfo;
import com.bob.product.dataobject.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-12 16:25
 * @Description:
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private ProductInfoMapper mapper;

    @Override
    public int insert(ProductInfo productInfo) {
        return mapper.insertByObject(productInfo);
    }

    @Override
    public List<ProductInfo> findByProductName(String productName) {
        //TODO 未完成
        return null;
    }

    @Override
    public int update(ProductInfo productInfo) {

        return mapper.updateByObject(productInfo);
    }

    @Override
    public int delete(String productId) {
        //TODO 未完成
        return 0;
    }

    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return mapper.findByProductStatus(productStatus);
    }

    @Override
    public List<ProductInfo> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<ProductInfo> findByProductIdList(List<String> productIdList) {
        return mapper.findByProductIdList(productIdList);
    }

    @Override
    public ProductInfo findById(String productId) {
        return mapper.findById(productId);
    }
}
