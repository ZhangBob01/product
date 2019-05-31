package com.bob.product.dataobject.mapper;

import com.bob.product.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 11:49
 * @Description:
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category (category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Delete("delete product_category where categroy_id = #{categroyId,jdbcType=INTEGER}")
    int deleteById(Integer categoryId);

    @Update("update product_category set category_name = #{categoryName,jdbcType=VARCHAR} where category_type = #{categoryType, jdbcType=INTEGER}")
    int updateByObject(ProductCategory productCategory);

    @Select("select * from product_category")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")
    })
    List<ProductCategory> findAll();

    @Select("select * from product_category where category_type = #{categoryType, jdbcType=INTEGER}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("<script>"
            + "SELECT * FROM product_category WHERE category_type IN "
            + "<foreach item='item' index='index' collection='typeList' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    @Results(value = {
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")
    })
    List<ProductCategory> findBytCategoryTypeIn(@Param("typeList") List<Integer> typeList);

}
