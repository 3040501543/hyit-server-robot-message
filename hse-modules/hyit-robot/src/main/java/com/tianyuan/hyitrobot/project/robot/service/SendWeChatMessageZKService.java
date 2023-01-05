package com.tianyuan.hyitrobot.project.robot.service;


import com.tianyuan.hyitrobot.project.robot.param.WechatMsgDto;

public interface SendWeChatMessageZKService {

    public boolean sendWechatMessageZK(WechatMsgDto dto);
}
