package com.feng.manage.server.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/5 17:02
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.feng.manage.data.storage.user.mapper"})
public class ServerUserApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ServerUserApplicationStarter.class, args);
    }

}
