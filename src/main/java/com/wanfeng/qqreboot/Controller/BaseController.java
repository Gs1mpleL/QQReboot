package com.wanfeng.qqreboot.Controller;

import com.wanfeng.qqreboot.domain.Result;
import com.wanfeng.qqreboot.domain.SendMsg;
import com.wanfeng.qqreboot.handler.MsgHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/qq")
public class BaseController {
    public static final Set<String> groupCache = new HashSet<>();
    public static final Set<String> memberCache = new HashSet<>();
    static {
        memberCache.add("804121985");
    }
    @Autowired
    private MsgHandler msgHandler;
    @PostMapping("/sendToEveryone")
    public Result sendToEveryone(@RequestBody SendMsg sendMsg){
        if (memberCache.isEmpty()){
            return new Result(false,"无人注册");
        }
        for (String s : memberCache) {
            msgHandler.getSender().sendPrivateMsg(s,sendMsg.getMsg());
        }
        return new Result(true,"发送完成");
    }

    @PostMapping("send/{qq}")
    public Result sendToOne(@PathVariable String qq,@RequestBody SendMsg sendMsg){
        msgHandler.getSender().sendPrivateMsg(qq,sendMsg.getMsg());
        return new Result(true,"发送完成");
    }

    @PostMapping("send/group")
    public Result sendGroup(@RequestBody SendMsg sendMsg){
        if (groupCache.isEmpty()){
            return new Result(false,"无群注册");
        }
        for (String s : groupCache) {
            msgHandler.getSender().sendGroupMsg(s,sendMsg.getMsg());
        }
        return new Result(true,"发送完成");
    }
}
