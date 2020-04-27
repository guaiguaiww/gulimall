package com.hww.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 *
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 22:28:18
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@TableName("pms_brand")
public class BrandEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @TableId
    private Long brandId;
    /**
     * 品牌名
     */
    @NotBlank(message = "name must not blank")
    private String name;
    /**
     * 品牌logo地址
     */
    @NotEmpty(message = "name must not blank")
    @URL(message = "logo必须为合理的url地址")
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    private Integer showStatus;
    /**
     * 检索首字母
     *
     * @Pattern : 自定义校验规则
     */
    //@Pattern(regexp = "/^[a-zA-Z]$/", message = "firstLetter必须为a-z或者A-Z")
    private Integer firstLetter;
    /**
     * 排序
     */
    @NotNull(message = "name must not blank")
    @Min(value = 0, message = "sort最小填0")
    private Integer sort;

}
