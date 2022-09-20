package com.wanfeng.qqreboot;

import cn.hutool.core.date.DateUtil;
import com.wanfeng.qqreboot.feign.TmuFeign;
import love.forte.common.configuration.Configuration;
import love.forte.simbot.annotation.SimbotApplication;
import love.forte.simbot.annotation.SimbotResource;
import love.forte.simbot.api.message.containers.BotInfo;
import love.forte.simbot.api.sender.BotSender;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.core.SimbotApp;
import love.forte.simbot.core.SimbotContext;
import love.forte.simbot.core.SimbotProcess;
import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


import java.util.Date;

/**
 * 启动类。
 * 其中，{@link SpringBootApplication} 为springboot的启动注解，
 * {@link EnableSimbot} 为simbot在springboot-starter下的启动注解。
 *
 * @author ForteScarlet
 */
@EnableSimbot
@SpringBootApplication
@EnableFeignClients
public class QqRebootApplication implements SimbotProcess{
    public static void main(String[] args) {
        SpringApplication.run(QqRebootApplication.class, args);
    }
    @Override
    public void post(@NotNull SimbotContext context) {
        Bot bot = context.getBotManager().getDefaultBot();
        BotSender sender = bot.getSender();
        sender.SENDER.sendPrivateMsg(804121985,buildBootString(bot.getBotInfo()));
    }
    @Override
    public void pre(@NotNull Configuration config) {

    }
    public static String buildBootString(BotInfo bot){
        return "机器人启动成功！\n" +
                "QQ:" + bot.getBotCode() +"\n" +
                "Name:" + bot.getBotName() + "\n" +
                "Time:" + DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
    }

}
