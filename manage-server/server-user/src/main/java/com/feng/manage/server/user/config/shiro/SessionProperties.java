package com.feng.manage.server.user.config.shiro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 14:17
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "ff-admin.session")
@Getter
@Setter
@ToString
public class SessionProperties {

    /**
     * session 失效时间（秒）
     */
    private Long timeout = 60L*60;

    /**
     * 验证失效时间间隔（秒）
     */
    private Long validInterval = 15L*60;
}

