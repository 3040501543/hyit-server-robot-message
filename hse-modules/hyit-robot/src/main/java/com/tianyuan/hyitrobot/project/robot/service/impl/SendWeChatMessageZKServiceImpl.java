package com.tianyuan.hyitrobot.project.robot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hyit.common.base.result.BaseResult;
import com.tianyuan.hyitrobot.project.robot.param.WechatMsgDto;
import com.tianyuan.hyitrobot.project.robot.service.SendWeChatMessageZKService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SendWeChatMessageZKServiceImpl implements SendWeChatMessageZKService {

    public boolean sendWechatMessageZK(WechatMsgDto dto) {
//        String[] userCodes = new String[]{"L2110010","L2203024"};
//        dto.setCompanyCode("test");
//        dto.setCompanyName("测试");
//        dto.setContent("12月15日测试信息");
//        dto.setKey("sendemailkey");
//        dto.setTitle("");
//        dto.setType("wechat");
//        dto.setUserCodes(dto.getUserCodes());
        //访问接口拿到数据
        //创建rest请求
        RestTemplate restTemplate = new RestTemplate();
        //1.请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        //3.响应体
        HttpEntity httpEntity = new HttpEntity(JSONObject.toJSONString(dto), httpHeaders);
        //发送企业微信消息请求
        BaseResult body = restTemplate.postForEntity("http://esbtest.shhuayi.com:9993/shljprd/supos/SendMessage", httpEntity, BaseResult.class).getBody();
        if (body.getCode().equals(HttpStatus.OK.toString().substring(0,3))) {
            return true;
        }
        return false;
    }
}
