package com.feng.manage.data.storage.user.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;
import java.util.List;

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
 * @since 2019-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

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

}
