package com.bob.product.service.impl;

import com.bob.product.common.DecreaseStockInput;
import com.bob.product.common.ProductInfoOutput;
import com.bob.product.dao.ProductDAO;
import com.bob.product.dataobject.ProductInfo;
import com.bob.product.enums.ResultEnum;
import com.bob.product.exception.ProductException;
import com.bob.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 09:04
 * @Description:
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public int insert(ProductInfo productInfo) {
        return productDAO.insert(productInfo);
    }

    @Override
    public int update(ProductInfo productInfo) {
        return productDAO.update(productInfo);
    }

    @Override
    public List<ProductInfo> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return productDAO.findByProductStatus(productStatus);
    }

    @Override
    public List<ProductInfoOutput> findByProductIdList(List<String> productIdList) {
        //lambda表达式
        return productDAO.findByProductIdList(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput productInfoOutput = new ProductInfoOutput();
                    BeanUtils.copyProperties(e,productInfoOutput);
                    return productInfoOutput;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = ProductException.class)
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList){
        for (DecreaseStockInput decreaseStockInput:decreaseStockInputList){
            //1.查询商品
            ProductInfo productInfo = productDAO.findById(decreaseStockInput.getProductId());
            //2.判断商品是否存在,不存在抛异常
            if(productInfo == null){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            //3.查询数量
            Integer quantity = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if(quantity < 0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //4.扣库存
            productInfo.setProductStock(quantity);
            productDAO.update(productInfo);
        }
    }
}
