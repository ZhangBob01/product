package com.bob.product.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: toudaizhi
 * @Date: 2019-04-14 11:38
 * @Description:
 */
@Data
public class ProductCategory {

    /** 类目ID. */
    private Integer categoryId;

    /** 类目名称. */
    private String categoryName;

    /** 类别. */
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

}
