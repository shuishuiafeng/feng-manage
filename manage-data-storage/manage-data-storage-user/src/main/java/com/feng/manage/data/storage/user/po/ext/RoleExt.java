package com.feng.manage.data.storage.user.po.ext;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.feng.manage.data.storage.user.po.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 11:01
 * @Description: 角色ext
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoleExt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String name;
    private Integer delFlag;
    private Boolean defaultRole;
    private String description;
    private Integer dataType;

    private List<Permission>  permissions;

}
