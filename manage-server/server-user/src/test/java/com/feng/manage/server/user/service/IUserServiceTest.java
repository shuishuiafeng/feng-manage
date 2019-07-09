package com.feng.manage.server.user.service;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.feng.manage.data.storage.user.po.ext.UserExt;
import com.feng.manage.server.user.ServerUserApplicationStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 15:29
 * @Description:
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = ServerUserApplicationStarter.class)
@Profile(value = "dev")
public class IUserServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(IUserService.class);

    @Resource
    private IUserService userService;

    @Test
    public void getUserExtByUserName() {
        UserExt user = userService.getUserExtByUserName("admin");
        logger.info("user is {}", user);
    }
}
