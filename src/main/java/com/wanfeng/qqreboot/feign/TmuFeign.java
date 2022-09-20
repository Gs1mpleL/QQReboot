package com.wanfeng.qqreboot.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "www.baidu.com",value = "xxx")
public interface TmuFeign {
    @RequestMapping("/")
    String test();
}
