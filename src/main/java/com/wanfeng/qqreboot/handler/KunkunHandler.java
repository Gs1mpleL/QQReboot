package com.wanfeng.qqreboot.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KunkunHandler {
    public static List<String> list = new ArrayList<>();
    static {
        list.add("又黑我家鸽鸽,");
        list.add("律师函警告,");
        list.add("食不食油饼?");
        list.add("再黑紫砂了,");
        list.add("我不想看见一张,");
        list.add("香精煎鱼食不是食,");
        list.add("你最好是,");
    }
    public static String getOne(){
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }
}
