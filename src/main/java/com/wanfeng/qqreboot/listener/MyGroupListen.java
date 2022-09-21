package com.wanfeng.qqreboot.listener;


import com.wanfeng.qqreboot.handler.KunkunHandler;
import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.api.message.MessageContent;
import love.forte.simbot.api.message.MessageContentBuilder;
import love.forte.simbot.api.message.MessageContentBuilderFactory;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.sender.Sender;
import love.forte.simbot.core.SimbotContext;
import love.forte.simbot.filter.MatchType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 群消息监听的示例类。
 * 所有需要被管理的类都需要标注 {@link Beans} 注解。
 *
 * @author ForteScarlet
 */
@Service
public class MyGroupListen {

    /** log */
    private static final Logger LOG = LoggerFactory.getLogger(MyGroupListen.class);
    @Autowired
    private MessageContentBuilderFactory messageContentBuilderFactory;
    private final Map<String, Set<String>> aikunMap = new HashMap<>();
    @Autowired
    private SimbotContext simbotContext;

    @OnGroup
    @Filter(value = ".*[鸡|鸽|律师|哎哟|你干嘛].*", matchType = MatchType.REGEX_MATCHES)
    public void onGroupMsg(GroupMsg groupMsg, Sender sender) {
        MessageContentBuilder msgBuilder = messageContentBuilderFactory.getMessageContentBuilder();
        MessageContent build = msgBuilder.text(KunkunHandler.getOne() + groupMsg.getAccountInfo().getAccountNickname()).face(1).build();
        sender.sendGroupMsg(groupMsg, build);
        Set<String> set = aikunMap.computeIfAbsent(groupMsg.getGroupInfo().getGroupCode(), k -> new HashSet<>());
        set.add(groupMsg.getAccountInfo().getAccountNickname());
        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s).append("\n");
        }
        sb.append("法院见");
        MessageContent build1 = msgBuilder.clear().text(sb.toString()).build();
        sender.sendGroupMsg(groupMsg, build1);
    }
}
