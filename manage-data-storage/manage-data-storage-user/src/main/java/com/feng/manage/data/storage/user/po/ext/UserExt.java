package com.feng.manage.data.storage.user.po.ext;

import com.baomidou.mybatisplus.annotations.TableId;
import com.feng.manage.data.storage.user.po.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 10:26
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserExt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String address;
    private String avatar;
    private String description;
    private String email;
    private String mobile;
    private String nickName;
    private String password;
    private Integer sex;
    private Integer status;
    private Integer type;
    private String username;
    private Integer delFlag;
    private String street;
    private String passStrength;
    private String salt;
    private List<RoleExt> roles;
}
