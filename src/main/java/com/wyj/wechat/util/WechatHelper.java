package com.wyj.wechat.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.wyj.wechat.exception.HttpProcessException;
import com.wyj.wechat.util.common.HttpConfig;

@Component
public class WechatHelper {
	
	@Value("${wx.appId}")
	private  String appId;
	@Value("${wx.secret}")
	private  String secret;
	@Value("${wx.tokenPath}")
	private String tokenPath;
	/**
	 * 获取token
	 */
	public  String getAccessToken() {
		System.out.println(this.appId);
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+this.appId+"&secret="+this.secret;
		HttpConfig  config = HttpConfig.custom();
		//简单调用
		String resp = null;
		try {
			resp = HttpUtil.get(config.url(url));
		} catch (HttpProcessException e) {
			e.printStackTrace();
		}
		JSONObject respObject =JSONObject.parseObject(resp);
		
		return respObject.getString("access_token");
	}
	
	
}
