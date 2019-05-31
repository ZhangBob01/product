package com.bob.product.service.impl;

import com.bob.product.common.ProductInfoOutput;
import com.bob.product.dataobject.ProductInfo;
import com.bob.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: toudaizhi
 * @Date: 2019-05-21 13:50
 * @Description:
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;
    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByProductStatus() {
    }

    @Test
    public void findByProductIdList() {
        List<String> idList = new ArrayList<>();
        idList.add("1550741890426549552");
        idList.add("1550741965345839506");
        idList.add("1551072716115867614");
        List<ProductInfoOutput> productInfoList = productService.findByProductIdList(idList);
        for (ProductInfoOutput productInfo:productInfoList) {
            System.out.println(productInfo);
        }
    }

    @Test
    public void decreaseStock() {
    }
}