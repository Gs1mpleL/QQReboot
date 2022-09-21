package com.wanfeng.qqreboot.handler;

import love.forte.simbot.api.sender.Sender;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.core.SimbotContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgHandler {
    @Autowired
    private SimbotContext simbotContext;

    public Sender getSender(){
        Bot bot = simbotContext.getBotManager().getDefaultBot();
        return bot.getSender().SENDER;
    }
}
