package com.wanfeng.qqreboot.listener;


import com.wanfeng.qqreboot.Controller.BaseController;
import com.wanfeng.qqreboot.handler.KunkunHandler;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.MessageContent;
import love.forte.simbot.api.message.MessageContentBuilder;
import love.forte.simbot.api.message.MessageContentBuilderFactory;
import love.forte.simbot.api.message.containers.AccountInfo;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.Sender;
import love.forte.simbot.filter.MatchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPrivateListen {
    @Autowired
    private MessageContentBuilderFactory messageContentBuilderFactory;


    @OnPrivate
    @Filter("注册")
    public void registerMember(PrivateMsg privateMsg, Sender sender){
        AccountInfo accountInfo = privateMsg.getAccountInfo();
        BaseController.memberCache.add(accountInfo.getAccountCode());
        sender.sendPrivateMsg(accountInfo.getAccountCode(),"注册成功");
    }


    @OnPrivate
    @Filter(value = ".*[鸡|鸽|律师|哎哟|你干嘛|ji|律师函|我家].*", matchType = MatchType.REGEX_MATCHES)
    public void kunkun(PrivateMsg privateMsg, Sender sender) {
        // 获取消息正文。
        MessageContent msgContent = privateMsg.getMsgContent();

        MessageContentBuilder msgBuilder = messageContentBuilderFactory.getMessageContentBuilder();

        MessageContent build = msgBuilder.text(KunkunHandler.getOne() + privateMsg.getAccountInfo().getAccountNickname()).face(1).build();
        sender.sendPrivateMsg(privateMsg, build);
    }


}
