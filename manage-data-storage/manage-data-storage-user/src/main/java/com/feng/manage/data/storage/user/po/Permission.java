package com.feng.manage.data.storage.user.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Administrator
 * @since 2019-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String createBy;
    private Date createTime;
    private Integer delFlag;
    private String updateBy;
    private Date updateTime;
    private String description;
    private String name;
    private Integer parentId;
    private Integer type;
    private BigDecimal sortOrder;
    private String component;
    private String path;
    private String title;
    private String icon;
    private Integer level;
    private String buttonType;
    private Integer status;
    private String url;


}
