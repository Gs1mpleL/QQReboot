package com.wanfeng.qqreboot;

import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableSimbot
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableAsync
public class QqRebootApplication{
    public static void main(String[] args) {
        SpringApplication.run(QqRebootApplication.class, args);
    }
}
