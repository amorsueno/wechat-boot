package com.wyj.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyj.wechat.util.WechatHelper;

@RestController 
public class TestController {
	@Autowired
	WechatHelper wechatHelper;
	
	@RequestMapping("/index")
    public String index(){
		String token = wechatHelper.getAccessToken();
        return token;
    }
	
	@RequestMapping("/msg")
    public String receive(){
		String token = wechatHelper.getAccessToken();
        return token;
    }
}
