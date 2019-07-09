package com.feng.manage.data.storage.user.mapper.ext;

import com.feng.manage.data.storage.user.po.ext.UserExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 10:30
 * @Description: 用户mapper
 */
@Mapper
public interface UserMapperExt {

    UserExt getUserExtByUserName(@Param("username") String userName);

}
