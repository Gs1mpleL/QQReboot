package com.wanfeng.qqreboot;

import com.wanfeng.qqreboot.handler.MsgHandler;
import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@EnableSimbot
@SpringBootApplication
public class QqRebootApplication implements ApplicationContextAware {
    public static void main(String[] args) {
        SpringApplication.run(QqRebootApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MsgHandler msgHandler = (MsgHandler) applicationContext.getBean("msgHandler");
        msgHandler.getSender().sendPrivateMsg("804121985","机器人启动成功！");
    }
}
