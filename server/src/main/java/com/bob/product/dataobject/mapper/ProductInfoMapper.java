package com.bob.product.dataobject.mapper;

import com.bob.product.dataobject.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-12 11:05
 * @Description:
 */
public interface ProductInfoMapper {
    /**
     * 新增商品
     * @param productInfo
     * @return
     */
    @Insert("INSERT INTO product_info (product_id, product_name, product_price, product_stock, product_status, product_description, product_icon, category_type) " +
            "VALUES(#{productId,jdbcType=VARCHAR},#{productName,jdbcType=VARCHAR},#{productPrice,jdbcType=DECIMAL},#{productStock,jdbcType=INTEGER},#{productStatus,jdbcType=INTEGER},#{productDescription,jdbcType=VARCHAR},#{productIcon,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductInfo productInfo);

    /**
     * 查询商品列表
     * @return
     */
    @Select("select * from product_info p")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "product_description", property = "productDescription"),
            @Result(column = "product_icon", property = "productIcon"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_price", property = "productPrice"),
            @Result(column = "product_status", property = "productStatus"),
            @Result(column = "product_stock", property = "productStock"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "create_time", property = "createTime")
    })
    List<ProductInfo> findAll();

    @Select("select * from product_info where product_status = #{productStatus}")
    @Results({
            @Result(column = "product_id",property = "productId"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "product_description", property = "productDescription"),
            @Result(column = "product_icon", property = "productIcon"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_price", property = "productPrice"),
            @Result(column = "product_status", property = "productStatus"),
            @Result(column = "product_stock", property = "productStock"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "create_time", property = "createTime")
    })
    List<ProductInfo> findByProductStatus(Integer productStatus);


    List<ProductInfo> findByProductIdList(@Param(value = "productIdList") List<String> productIdList);

    /**
     * 根据Id查询商品
     * @param productId
     * @return
     */
    @Select("select * from product_info p where product_id = #{productId}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "product_description", property = "productDescription"),
            @Result(column = "product_icon", property = "productIcon"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_price", property = "productPrice"),
            @Result(column = "product_status", property = "productStatus"),
            @Result(column = "product_stock", property = "productStock"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "create_time", property = "createTime")
    })
    ProductInfo findById(String productId);

    @Update("<script> " +
            "update product_info p " +
            "<set>" +
            "<if test='productName != null'> p.product_name = #{productName} ,</if> " +
            "<if test='productPrice != null'> p.product_price = #{productPrice},</if> " +
            "<if test='productStatus != null'> p.product_status = #{productStatus},</if> " +
            "<if test='productStock != null'> p.product_stock = #{productStock},</if> " +
            "<if test='categoryType != null'> p.category_type = #{categoryType},</if>" +
            "<if test='productIcon != null'> p.product_icon = #{productIcon},</if> " +
            "</set> where p.product_id = #{productId} " +
            "</script>")
    int updateByObject(ProductInfo productInfo);
}
