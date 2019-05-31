package com.bob.product.controller;

import com.bob.product.common.DecreaseStockInput;
import com.bob.product.common.ProductInfoOutput;
import com.bob.product.VO.ProductInfoVO;
import com.bob.product.VO.ProductVO;
import com.bob.product.VO.ResultVO;
import com.bob.product.dataobject.ProductCategory;
import com.bob.product.dataobject.ProductInfo;
import com.bob.product.enums.ProductStatusEnums;
import com.bob.product.service.CategoryService;
import com.bob.product.service.ProductService;
import com.bob.product.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 09:11
 * @Description:
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> findAllProduct(){
        //1.查询所有在架商品
        List<ProductInfo> productInfoList = productService.findByProductStatus(ProductStatusEnums.UP.getCode());
        //2.获取在架商品所在类目
        List<Integer> typeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        //3.获取类目信息
        List<ProductCategory> productCategoryList = categoryService.findProductCategoryIn(typeList);
        //4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
//        for (ProductCategory productCategory:productCategoryList ){
//            ProductVO productVO = new ProductVO();
//            productVO.setCategoryName(productCategory.getCategoryName());
//            productVO.setCategoryType(productCategory.getCategoryType());
//
//            //构造ProductInfoVOList
//            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
//            for (ProductInfo productInfo:productInfoList){
//                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
//                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                    BeanUtils.copyProperties(productInfo,productInfoVO);
//                    productInfoVOList.add(productInfoVO);
//                }
//
//            }
//            productVO.setProductInfoVOList(productInfoVOList);
//            productVOList.add(productVO);
//        }

        //4.1 根据类目分组
        Map<String,List<ProductInfoVO>> productInfoVOListMap = new HashMap<>();

        for (ProductInfo productInfo:productInfoList) {
            ProductInfoVO productInfoVO = new ProductInfoVO();
            BeanUtils.copyProperties(productInfo,productInfoVO);

            //判断类目是否存在map中
            if (productInfoVOListMap.get(productInfo.getCategoryType()+"")==null){
                List<ProductInfoVO> productInfoVOList = new ArrayList<>();
                productInfoVOList.add(productInfoVO);
                productInfoVOListMap.put(productInfo.getCategoryType()+"",productInfoVOList);
            }else {

                List<ProductInfoVO> productInfoVOList = productInfoVOListMap.get(productInfo.getCategoryType()+"");
                productInfoVOList.add(productInfoVO);
                productInfoVOListMap.put(productInfo.getCategoryType()+"",productInfoVOList);
            }


        }
        for (ProductCategory productCategory:productCategoryList ){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setProductInfoVOList(productInfoVOListMap.get(productCategory.getCategoryType()+""));
            productVOList.add(productVO);
        }


        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表（订单中商品）
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList){
        List<ProductInfoOutput> productInfoOutputList = productService.findByProductIdList(productIdList);

        return productInfoOutputList;
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productService.decreaseStock(decreaseStockInputList);
    }
}
