package com.feng.manage.assist.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/4 17:47
 * @Description: 微服务注册中心
 */
@SpringBootApplication
@EnableEurekaServer //EurekaServer服务器端启动类,接受其它微服务注册进来
public class AssistEurekaRegisterApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(AssistEurekaRegisterApplicationStarter.class, args);
    }

}
